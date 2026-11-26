# Aster

**Connect freely. Cost nothing.** Native Android (Kotlin + Jetpack Compose) messenger scaffold.
Original brand. Zero-cost by design: no paid backend, no ads, no tracking, no paid tier, no paid
CI, no Play Store fee. End-to-end encryption, P2P, calls, storage are **planned targets, not yet
wired**. **Not audited. Not a finished messenger.**

- Plan & honest scope: [docs/PLAN.md](docs/PLAN.md)
- Feature targets vs Signal/WhatsApp + 2027: [docs/FEATURES.md](docs/FEATURES.md)
- Zero-cost engineering + cost ledger: [docs/ZERO_COST.md](docs/ZERO_COST.md)
- Architecture (honest status): [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md)
- Brand identity: [docs/BRAND.md](docs/BRAND.md) · logo [docs/logo.svg](docs/logo.svg)

## Build APK (free, no Android Studio needed)

Push to `main`. `.github/workflows/android-apk.yml` builds a debug-signed, sideloadable APK on a
free GitHub Actions runner; download the `aster-apk` artifact. Or run `workflow_dispatch` manually.

## Build locally

Install JDK 17 + Android SDK (free) + Gradle 8.11.1, then:

```sh
gradle :app:assembleDebug      # app/build/outputs/apk/debug/app-debug.apk
```

No proprietary SDKs. No Google Play Services required. No paid anything.

## License

Apache-2.0 (target). Brand name/logo reserved; forks rebrand. No ads. No tracking. No paid tier.
