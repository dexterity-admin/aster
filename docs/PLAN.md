# Aster — full plan (and honest scope)

## 1. Objective restated

A **native Android** app, named **Aster**, aiming to **match Signal/WhatsApp and add 2027 features**
(see `FEATURES.md`), **zero cost** to build, run, maintain, call, store, and use (see `ZERO_COST.md`),
**own brand identity** (see `BRAND.md`), buildable to an **APK via GitHub Actions**, pushed to GitHub.

## 2. Reality check (honest, not marketing)

- **"Beats Signal and WhatsApp in features" is a target, not a verified claim.** No benchmarks, no
  audit, no user studies, no finished messenger. This session produces a **working native scaffold +
  complete plan + honest docs**, not a production messenger.
- **Zero cost cannot be literal at global scale** (hardware/bandwidth cost *someone*). We promise
  **nothing *we* pay, nothing mandatory, no paid backend, no ads, no tracking, no paid tier**. Real
  reliability needs optional volunteer/self-hosted relays. See `ZERO_COST.md`. Not a physics miracle.
- **E2EE, transport, calls are `[scaffold]`/`[planned]`, not wired.** **Not audited. Not secure for
  real private communication yet.** No proprietary paid components. No guarantee of being unhackable.
- **No local Android SDK/Gradle** on this machine; **Java 17** present. So APK is built via **GitHub
  Actions** on a GitHub-hosted runner (free). Can't locally `gradle assembleDebug` here.
- **GitHub account:** `vikramdex-ops` was requested, **but house rules forbid it**; using active
  **`dexterity-admin`**. (User can change the rule at system level.) Repo: `aster`.
- **App name:** `Lumen` rejected; renamed **Aster**. Brand is original, not Signal/WhatsApp.
- **Not asked/not done:** Play Store submission, paid distribution, signed *release* keystore
  (secret), F-Droid metadata completion, real backend, real crypto, tests at scale. Honest list in §7.

## 3. What was actually built this session (concrete, compiling scaffold)

Native Android, Kotlin, Jetpack Compose, Material 3. No proprietary/paid SDKs. Targets compileSdk
34, minSdk 26, JDK 17, AGP 8.7.3, Kotlin 2.0.21, Compose BOM 2024.12.01.

**Files (app `app.aster`):**
- `settings.gradle.kts`, `build.gradle.kts`, `app/build.gradle.kts`, `gradle.properties`, `.gitignore`
- `app/src/main/AndroidManifest.xml` (no backup, no Google services, minimal permissions)
- `app/src/main/java/app/aster/MainActivity.kt`
- `app/src/main/java/app/aster/ui/AsterApp.kt` (Chats / Calls / Aster / Settings; chat view; sample data)
- `app/src/main/java/app/aster/ui/theme/{Color,Theme}.kt`
- `app/src/main/java/app/aster/model/Models.kt`
- resources: `values/{strings,colors,themes}.xml`, adaptive icon `mipmap-anydpi-v26`,
  `drawable/ic_launcher_{foreground,background}.xml`, `xml/data_extraction_rules.xml`
- `.github/workflows/android-apk.yml` (free CI → debug-signed APK artifact)
- `docs/{PLAN,BRAND,ARCHITECTURE,ZERO_COST,FEATURES}.md`, `docs/logo.svg`, `README.md`

**Brand:** Aster Violet `#5B3FD9` + Aster Nova `#FF6B3D` + Sage `#2FAE8F`, ink dark-first; star-in-
bubble mark; tagline "Connect freely. Cost nothing." Original, not Signal blue / WhatsApp green.

## 4. Architecture summary

Local-first, no mandatory backend, E2EE-by-default target, pluggable transport (P2P WebRTC +
optional self-hosted ciphertext relay + offline BLE/Wi-Fi-Direct mesh), on-device encrypted storage,
WebRTC E2EE calls (free STUN; optional self-hosted TURN; no paid telephony), UnifiedPush/offline,
on-device AI (no cloud, no cost), zero paid anything. Detail: `ARCHITECTURE.md`. Honestly marked
scaffold vs planned.

## 5. Zero-cost summary

No paid services at any point; no server we run or pay for; no ads/tracking/telemetry; no paid
store fee; no paid CI; no paid push; no paid calls/storage; FOSS; reproducible; no proprietary
SDKs; no paid maintenance. Cost ledger in `ZERO_COST.md`. Residual reality in §2.

## 6. Build pipeline (chosen: GitHub Actions, free)

Repo `aster`, branch `main`. Workflow `.github/workflows/android-apk.yml`:
`actions/checkout@v4` → `actions/setup-java@v4` (Temurin 17) → `gradle/actions/setup-gradle@v4`
(Gradle 8.11.1) → `gradle :app:assembleDebug` → `actions/upload-artifact@v4` `aster-apk`.
Output `app/build/outputs/apk/debug/app-debug.apk` (applicationId `app.aster.debug`). No secrets,
no paid signing, no Play Store, no Android Studio needed, public repo = free minutes.

**Release (later):** generate a local keystore **you** keep (never committed; `.gitignore` blocks
`*.jks`/`*.keystore`); signed release APK + F-Droid; **no paid** service. Not done here.

## 7. Roadmap phases (honest order; nothing paid)

- **P0 (this session):** name, brand, scaffold, docs, CI/APK pipeline, honesty.
- **P1:** local-first data + on-device encrypted store; real chat UI; no-cloud baseline.
- **P2:** E2EE via libsignal (hybrid PQ); key verification; **independent audit before any real use**.
- **P3:** transport: P2P WebRTC + optional self-hosted relay + offline mesh; no paid backend.
- **P4:** calls: WebRTC 1:1 + group E2EE; free STUN; optional self-hosted TURN; call links.
- **P5:** 2027 features in `FEATURES.md`; on-device AI; no paid anything.
- **P6:** accessibility/i18n; foldables; notifications/UnifiedPush; multi-account/linked devices.
- **P7:** F-Droid + reproducible releases; security audit; community governance; **still $0**.

## 8. Honesty list (not done / not verified)

- Not a finished messenger; not production; not audited; not secure for real private comms yet.
- "Beats Signal/WhatsApp" unproven; no benchmarks/audit.
- Zero-cost proven only as **nothing-we-pay / no-paid-anything**, not literal global physics.
- Crypto/transport/calls/storage/backup/push/AI **not implemented**; only scaffold + docs.
- No independent security review; no tests at scale; no signed release keystore; no F-Droid yet.
- No local Android build here; relies on GitHub Actions (network + GitHub account).
- GitHub account forced to `dexterity-admin` per house rules, overriding requested `vikramdex-ops`.
- App name `Lumen` replaced with `Aster`.
