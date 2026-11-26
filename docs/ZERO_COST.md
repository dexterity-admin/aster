# Zero-cost engineering: how "nothing costs us money" is actually achieved

Goal restated: the app and its maintenance cost **nothing** — no server bills, no paid APIs, no
ads, no tracking revenue, no in-app purchases, no paid tier, no Play Store fee, no paid CI, no paid
storage, no per-minute call charges, no paid push, no paid analytics/crash tools, no paid fonts/SDKs.

## The honest ceiling (read this first)

No app can truthfully promise **literally $0 hardware/bandwidth at global scale** while also
guaranteeing free calls + free storage for everyone. Phones, electricity, and network bandwidth
cost *someone*. Signal and WhatsApp pay for servers; we simply choose **not to run one**. Our
zero-cost claim is precise:

> **We pay nothing. We run nothing that must be paid for. There is no mandatory paid backend.**

Everything expensive is pushed onto (a) user devices and (b) optional infrastructure that users or
communities self-host for free, or volunteer/public free services. If no central server exists, we
cannot be billed for it. The trade-off is reliability at scale, which `ARCHITECTURE.md` addresses
honestly.

Also honest: a fully offline **pure-P2P** app cannot guarantee delivery when both parties are
offline at once without *some* relay. A relay costs bandwidth whoever runs it. Our design makes
relays **optional, self-hostable, zero-cost-to-us, and not required for basic use**; it does not
pretend relays are free in physics.

## Cost ledger — every line is $0 to us

| Area | Solution | Cost to us |
|---|---|---|
| Source hosting | GitHub public repo (or any git host) | $0 |
| CI / APK build | GitHub Actions free tier, no secrets, no paid signing | $0 |
| App distribution | Sideload APK + F-Droid; **no Google Play $25 fee** | $0 |
| Backend | None required. No server we run. Optional self-hosted relay. | $0 |
| Messaging infra | P2P WebRTC / data channels + pluggable free relay; no paid messaging API | $0 |
| Calls | WebRTC; free STUN; optional community/self-hosted TURN; no per-minute | $0 |
| Media/storage | On-device; no app-imposed quota; optional user-owned storage; P2P transfer | $0 |
| Push | UnifiedPush + offline sync; no paid push; FCM not required | $0 |
| Encryption | Android Keystore (free); open-source crypto; no paid HSM required | $0 |
| AI features | On-device; no cloud API; no paid tokens; optional offline models | $0 |
| Dependencies | FOSS only (AndroidX/Kotlin); no proprietary paid SDKs | $0 |
| Fonts/assets | System font; OFL; original Aster brand; no paid assets | $0 |
| Analytics/crash/ads | **None.** Nothing to pay for. No data to monetize. | $0 |
| Maintenance | FOSS + community + reproducible builds; no paid support required | $0 |

## "Generous for users" at zero cost to us

- No storage quota imposed by the app; storage = user's own device + optional user-owned backup.
- No call-minute limits; no call-length caps; no paid tiers.
- No message-size cap imposed by a paid plan; large media streams P2P / chunked.
- No feature is locked behind payment; no ads ever; no tracking ever.
- Nothing the user must pay a third party to use core Aster.

## Free-to-run infrastructure options (all $0, self-hostable, no proprietary lock-in)

- Relay: any free static host / commodity box / community node; optional; self-hostable; not required.
- Offline mesh: Bluetooth LE + Wi-Fi Direct; no internet, no server, no cost.
- Backup: export encrypted archive to user's own free storage; no app cloud.
- Build: GitHub Actions free tier for public repos; F-Droid; reproducible builds.
- No DNS-over-paid, no CDN required, no paid certs (optional free Let's Encrypt for self-hosters).

## Maintenance at $0

- Apache-2.0 FOSS; reproducible builds; minimal dependency surface; no proprietary blobs.
- No telemetry means no pipeline to maintain and no data-privacy cost; no ads means no ad partner.
- No paid hosted instance; no ops team required; app runs with zero server we must operate.
- Updates shipped as free APK/F-Droid releases; no paid app-store review fees.

## What would NOT be free (explicitly avoided)

Paid APIs, paid cloud storage, paid push, paid CI minutes, Play Store developer fee, paid TURN,
paid analytics, paid ads SDKs, paid fonts, paid support contracts, mandatory paid tier, any data
monetization. None are used.

## Residual reality

Reliability-at-scale and "no bandwidth cost anywhere in the world" cannot both be perfectly true
without someone's hardware. We optimize for **zero cost to us and to users**, not a physics miracle.
A serious production version would need community-funded or volunteer relays; even then, nothing we
operate is a paid service. Crypto + transport in this repo are **scaffolds**, not audited. See
`PLAN.md` honesty list.
