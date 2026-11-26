package app.aster.model

/** Local-first data model. Nothing here requires a server or paid storage. */
data class Contact(val id: String, val name: String, val safetyNumber: String)

data class Message(
    val id: String,
    val text: String,
    val fromMe: Boolean,
    val timestampMillis: Long,
)

data class Chat(
    val id: String,
    val title: String,
    val preview: String,
    val unread: Int,
    val timestampMillis: Long,
    val contact: Contact? = null,
)

object SampleData {
    val me = Contact("me", "You", "—")
    val chats: List<Chat> = listOf(
        Chat("1", "Aster Community", "Welcome to Aster. No ads. No tracking. Cost nothing.", 2, 1_000L),
        Chat("2", "Ravi", "See you at 6?", 0, 900L, Contact("ravi", "Ravi", "12 345 678 9012 3456")),
        Chat("3", "Family", "Dinner photos added", 0, 800L),
        Chat("4", "Aria", "On-device only. Nothing leaves your phone.", 1, 700L, Contact("aria", "Aria", "98 765 4321 0987 6543")),
    )
    val messages: List<Message> = listOf(
        Message("m1", "End-to-end encrypted. No cloud required.", fromMe = false, timestampMillis = 100L),
        Message("m2", "Nice. Does it cost anything?", fromMe = true, timestampMillis = 200L),
        Message("m3", "No. Free forever. No ads. No tracking. No paid tier.", fromMe = false, timestampMillis = 300L),
    )
}
