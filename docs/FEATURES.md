# Feature targets — "everything a great 2027 messenger needs"

Honest status legend: `[built]` in this scaffold · `[planned]` · `[scaffold]`. **Nothing below is
claimed as finished.** The claim "beats Signal and WhatsApp" is a **target**, not a verified fact;
no benchmarks, no audit, no user studies. Core messaging/calls/E2EE are **not** wired yet.

## Parity baseline (what Signal/WhatsApp have; Aster aims to match + exceed, free)

Messaging: 1:1 + large groups; text; rich formatting; replies; quotes; reactions; @mentions;
edits; delete; forward; pin; star; search; media (photo/video/audio/file); voice notes; stickers;
GIF (free sources); polls; location; contacts; link previews; drafts; scheduled send; disappearing
messages; view-once; saved messages; notes-to-self; broadcast/lists; channels; communities.
Calls: 1:1 + group audio/video; screen share; call links; lobby; ringing; PiP; speakerphone.
Security: E2EE; verified keys; disappearing; app lock; backups.
Multi-device; linked devices; notifications; status/stories; profile; block/report.

All targeted; **none verified built** beyond UI scaffolding.

## Aster 2027 additions (free + private, no paid tier, no cost)

### Messaging depth
- `[planned]` Undo-send window; scheduled send + recurring; message scheduling across timezones.
- `[planned]` Collaborative threads + reactions-with-text; message threads; topic channels.
- `[planned]` Rich blocks in chat (checklists, tables, code blocks w/ syntax, math, diagrams).
- `[planned]` On-device translation; on-device transcription; on-device OCR; encrypted local search.
- `[planned]` Voice notes waveform + variable speed + transcribe-on-device + edit; voice replies.
- `[planned]` Send-any-size encrypted files, chunked, P2P; no app quota; resume; previews.
- `[planned]` Screen-notes, annotated screenshots, E2EE albums; expiring media; view-once.
- `[planned]` Live location (consent, granular, expirable); no location server; on-device.
- `[planned]` Encrypted in-app docs/notebooks shared P2P; local-first collaborative editing.
- `[planned]` E2EE reactions; polls with privacy options; event RSVP; shared checklists; to-dos.
- `[planned]` Custom local sticker/emoji packs; no paid sticker store; community packs free.
- `[planned]` Message templates; snippets; smart compose **on-device** (no cloud AI, no cost).

### 2027 on-device AI (no cloud, no paid tokens, no tracking)
- `[planned]` On-device assistant: summarize chats, draft, rewrite, smart reply, ask-your-history
  with local encrypted index; model runs on device; nothing leaves phone; no API key; no cost.
- `[planned]` On-device moderation aid (opt-in, local); accessibility (describe image, read screen,
  simplify text, generate alt-text); on-device speech-to-text + text-to-speech; offline.
- `[planned]` "Incognito" toggle disabling any AI; every AI action explainable; no training on user
  data; no paid tier. Honestly: requires bundled/optional offline models; not built.

### Calls (audio/video, free, E2EE)
- `[scaffold]` Calls tab only. `[planned]` 1:1 + group WebRTC; HD/adaptive; spatial audio; noise
  suppression; echo cancel; background; PiP; screen share; reactions; on-device live captions;
  call recording (local, encrypted); waiting room; admin controls; call links (no account to join);
  schedule; calendar; voice rooms; live P2P streaming; local voicemail; call screening; block.
- `[planned]` No per-minute, no app charge, no paid telephony; no paid TURN (optional self-host).

### Privacy & security (2027 bar)
- `[planned]` E2EE everything incl. calls, files, backups; metadata minimization; sealed sender.
- `[planned]` No phone number required; username; optional passkeys (WebAuthn/FIDO2); hardware key.
- `[planned]` Android Keystore/StrongBox; encrypted local DB; app lock (biometric); incognito
  keyboard; screenshot protection (FLAG_SECURE); secure recents; no cloud backup of app data.
- `[planned]` Safety numbers; key-change alerts; optional verified badges; encrypted export.
- `[planned]` Duress/PIN hidden mode; hidden chats; panic wipe; remote wipe; lost-device mode.
- `[planned]` Disappearing messages incl. media; screenshot notices; read receipts optional;
  online status optional; no read tracking; no ads; no telemetry; no data sale; no paid upsell.
- `[planned]` Hybrid post-quantum key exchange target; reproducible builds; open auditable code;
  no proprietary blobs; no Google Play Services requirement. **Not audited.**

### Offline, mesh, resilience
- `[planned]` Works offline; store-and-forward; sync on reconnect; P2P.
- `[planned]` Bluetooth LE + Wi-Fi Direct mesh; offline groups; sneakernet export; no internet.
- `[planned]` Optional self-hosted zero-cost relay; ciphertext-only; no paid cloud.

### Platform & UX (Android native 2027)
- `[built]` Native Kotlin + Compose scaffold; own Aster brand; adaptive icon; dark + light; RTL.
- `[planned]` Material 3 + dynamic + own scheme; foldables/tablets; big text; high contrast;
  color-blind safe; TalkBack; haptics; reduced motion; multi-language; widgets; share sheet;
  app shortcuts; notifications (granular, no paid push); UnifiedPush; multi-account; chat folders;
  archive; mute; pin; unread; linked devices; QR sync; desktop/web optional (same FOSS, no cost).
- `[planned]` No ads ever; no in-app purchases; no paid tier; no tracking; optional **voluntary**
  donation that unlocks nothing.

### Bots, API, portability
- `[planned]` Open protocol; local bots (no paid hosting); optional self-hosted webhooks; data
  export (JSON); no lock-in; self-hostable relay; F-Droid; reproducible.

## Status in this session

Only `[built]` items are real. `[scaffold]` is partial. `[planned]` is not implemented. Honesty
over marketing: Aster is **not** a finished messenger, not audited, not a Signal replacement yet.
See `PLAN.md`.
