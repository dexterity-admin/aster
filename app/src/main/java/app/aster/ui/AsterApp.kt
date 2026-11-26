package app.aster.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.aster.model.Message
import app.aster.model.SampleData

private enum class Tab(val label: String) { Chats("Chats"), Calls("Calls"), Aster("Aster"), Settings("Settings") }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AsterApp() {
    var tab by remember { mutableStateOf(Tab.Chats) }
    var openChatId by remember { mutableStateOf<String?>(null) }

    if (openChatId != null) {
        ChatDetailScreen(chatId = openChatId!!, onBack = { openChatId = null })
        return
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Aster") }) },
        bottomBar = {
            NavigationBar {
                Tab.entries.forEach { t ->
                    NavigationBarItem(
                        selected = tab == t,
                        onClick = { tab = t },
                        icon = { Icon(tabIcon(t), contentDescription = t.label) },
                        label = { Text(t.label) },
                    )
                }
            }
        }
    ) { padding ->
        Box(Modifier.padding(padding)) {
            when (tab) {
                Tab.Chats -> ChatsScreen(onOpenChat = { openChatId = it })
                Tab.Calls -> PlaceholderScreen("Calls", "1:1 & group audio/video, call links, on-device. Scaffold — no backend wired yet.")
                Tab.Aster -> AboutScreen()
                Tab.Settings -> PlaceholderScreen("Settings", "Privacy, security, appearance, no telemetry. Scaffold.")
            }
        }
    }
}

private fun tabIcon(tab: Tab) = when (tab) {
    Tab.Chats -> Icons.Filled.Chat
    Tab.Calls -> Icons.Filled.Call
    Tab.Aster -> Icons.Filled.Star
    Tab.Settings -> Icons.Filled.Settings
}

@Composable
private fun ChatsScreen(onOpenChat: (String) -> Unit) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(SampleData.chats) { chat ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .clickable { onOpenChat(chat.id) }
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    Modifier.size(44.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) { Text(chat.title.take(1), color = MaterialTheme.colorScheme.onPrimaryContainer, fontWeight = FontWeight.Bold) }
                Spacer(Modifier.width(12.dp))
                Column(Modifier.weight(1f)) {
                    Text(chat.title, style = MaterialTheme.typography.titleMedium)
                    Text(chat.preview, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 1)
                }
                if (chat.unread > 0) {
                    Box(
                        Modifier.size(22.dp).clip(CircleShape).background(MaterialTheme.colorScheme.tertiary),
                        contentAlignment = Alignment.Center
                    ) { Text(chat.unread.toString(), color = MaterialTheme.colorScheme.onTertiary, style = MaterialTheme.typography.labelSmall) }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ChatDetailScreen(chatId: String, onBack: () -> Unit) {
    val chat = SampleData.chats.firstOrNull { it.id == chatId }
    var draft by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(chat?.title ?: "Chat") },
                navigationIcon = { TextButton(onClick = onBack) { Text("Back") } },
                actions = { Icon(Icons.Filled.Videocam, contentDescription = "Video call") }
            )
        }
    ) { padding ->
        Column(Modifier.padding(padding).fillMaxSize()) {
            LazyColumn(Modifier.weight(1f).padding(12.dp)) {
                items(SampleData.messages) { m -> MessageBubble(m) }
            }
            Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                OutlinedTextField(
                    value = draft,
                    onValueChange = { draft = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Message") },
                )
                Spacer(Modifier.width(8.dp))
                Button(onClick = { /* shortcut: local-only send; E2EE transport not wired yet */ draft = "" }, shape = RoundedCornerShape(20.dp)) { Text("Send") }
            }
        }
    }
}

@Composable
private fun MessageBubble(m: Message) {
    Row(Modifier.fillMaxWidth().padding(vertical = 4.dp), horizontalArrangement = if (m.fromMe) Arrangement.End else Arrangement.Start) {
        Surface(
            color = if (m.fromMe) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                m.text,
                Modifier.padding(12.dp),
                color = if (m.fromMe) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
private fun PlaceholderScreen(title: String, note: String) {
    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(title, style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(8.dp))
        Text(note, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Composable
private fun AboutScreen() {
    Column(Modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(24.dp))
        Box(Modifier.size(72.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primary), contentAlignment = Alignment.Center) {
            Icon(Icons.Filled.Star, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimary, modifier = Modifier.size(40.dp))
        }
        Spacer(Modifier.height(16.dp))
        Text("Aster", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        Text("Connect freely. Cost nothing.", color = MaterialTheme.colorScheme.onSurfaceVariant)
        Spacer(Modifier.height(24.dp))
        Text(
            "Native Android. End-to-end encrypted. Local-first. No ads. No tracking. No paid tier. " +
                "No Google Play Services required. Open source. Zero running cost by design.",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(16.dp))
        Text(
            "This build is a working scaffold, not a finished messenger. See docs/PLAN.md for the full plan and honest scope.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
