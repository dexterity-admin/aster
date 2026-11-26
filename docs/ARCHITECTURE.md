# Architecture (zero-cost, local-first, no mandatory backend)

## Principles

1. **Local-first.** Source of truth is on the user's device. Works offline. No account required to
   start; no phone number required (username/keypair; optional recovery).
2. **No mandatory central server.** No backend we run or pay for. Optional self-hosted relay only.
3. **End-to-end encrypted by default** (target; see honesty note). Server/relay, if any, sees
   ciphertext only. No cloud reads messages.
4. **Nothing paid.** No proprietary paid SDKs, no paid APIs, no tracking. See `ZERO_COST.md`.
5. **Native Android.** Kotlin + Jetpack Compose. No cross-platform shell, no paid components.

## Layers

```
UI (Jetpack Compose, Material 3, own Aster scheme)
  └─ ViewModels (no backend assumptions)
Local store (on-device encrypted DB; Android Keystore-held keys)        [target]
Crypto (Signal Protocol / libsignal target; hybrid PQ X3DH + Double Ratchet; sealed sender)  [scaffold]
Transport (pluggable):
   - P2P WebRTC data channels                                           [scaffold]
   - optional self-hosted zero-cost relay (store-and-forward, ciphertext-only)   [not built]
   - offline mesh: Bluetooth LE + Wi-Fi Direct                          [not built]
Calls (WebRTC; free STUN; optional self-hosted TURN; E2EE; call links)  [not built]
Push (UnifiedPush; offline sync; no FCM requirement)                    [not built]
On-device AI (optional offline models; no cloud; no cost)               [not built]
```

## Encryption (honest status)

- **Target:** Signal Protocol via `libsignal`; hybrid post-quantum key exchange; sealed sender;
  per-conversation keys; encrypted local storage; encrypted backups; verified safety numbers.
- **This repo today:** no crypto is wired. UI + model only. **Not secure yet. Do not use for real
  private communication.** No independent audit. Marked `[scaffold]`, not `[done]`.

## Transport (honest status)

- No paid cloud messaging. No mandatory server. Pure-P2P cannot guarantee offline-while-offline
  delivery; optional ciphertext-only relay is the planned zero-cost answer. Not built in this
  scaffold. Not claimed working.

## Storage

- On-device only by default; no app-imposed quota ("generous"; bounded by device storage).
- No app-run cloud storage; optional export of an encrypted archive to user-owned storage.
- No tracking of stored content; no backup to us. `allowBackup=false`, no auto cloud backup.

## Calls

- WebRTC target; direct P2P preferred; free STUN; optional self-hosted/community TURN (no paid
  service); E2EE; no telephony billing; call links joinable without an account. Not built.

## Build & distribution (zero-cost)

- Native Android, Kotlin, Gradle, Compose. 
- GitHub Actions free tier builds a debug-signed sideloadable APK (`.github/workflows/android-apk.yml`).
- No Google Play Services required; no paid store; F-Droid-compatible target; reproducible builds.
- No proprietary/paid SDKs; AndroidX/Kotlin only.

## What this session actually built

A compiling native Android scaffold: brand theme, adaptive icon, chats list, chat view (UI only),
calls/settings placeholders, original Aster brand + docs. Everything networked/cryptographic is
intentionally **not** implemented; interfaces and honest docs are provided instead of faking it.
