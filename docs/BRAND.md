# Aster — brand identity

## Name

**Aster** — short, two-syllable, brandable, easy in any language, no clash with Signal/WhatsApp.
*Aster* is the Greek word for "star"; the mark is a star inside a speech bubble. The star also means
"open, lit, original". Spelling is exactly **Aster**. No abbreviation, no appended version numbers.

- Tagline: **Connect freely. Cost nothing.**
- Honesty note: tagline describes design intent, not a legal guarantee of literal zero infrastructure cost
  at global scale. See `ZERO_COST.md`. The app itself costs nothing, has no ads, no tracking, no paid tier.

## Original colour coding (not Signal blue, not WhatsApp green)

Own palette. Signal = Signal Blue; WhatsApp = green; **Aster = Aster Violet + Nova**, ink/dark-first.

| Role | Name | Hex | Use |
|---|---|---|---|
| Primary | **Aster Violet** | `#5B3FD9` | brand, buttons, sent bubbles, icon background |
| Primary dark | Aster Violet Dark | `#4330A8` | pressed states, containers |
| Primary light | Aster Violet Light | `#8A77F0` | dark-theme primary |
| Accent | **Aster Nova** | `#FF6B3D` | ember accent, unread, star in mark, key highlights |
| Secondary | Aster Sage | `#2FAE8F` | success, safe/verified, secondary actions |
| Ink | Aster Ink | `#0B0D12` | dark background |
| Surface | Aster Surface | `#161A22` | dark cards |
| Cloud | Aster Cloud | `#F6F4EF` | light background, on-dark text |
| Paper | Aster Paper | `#FFFFFF` | light cards |
| Muted | Aster Muted | `#9AA3B2` | secondary text |
| Error | — | `#FF6B6B` (dark) / `#B00020` (light) | errors |

Accessibility: target WCAG 2.2 AA contrast in both light and dark; colour is never the only signal;
dark-first with light theme; dynamic system font scaling; TalkBack labels; reduce-motion support.

## Logo

- Mark: star inside a rounded speech bubble; original geometry; no third-party logo.
- Flat vector; single colour inside brand-violet rounded-square app icon.
- Android adaptive icon: `app/src/main/res/drawable/ic_launcher_foreground.xml` + `ic_launcher_background.xml`.
- Source SVG: `docs/logo.svg`.
- Monochrome (Android 13+ themed icons) target; safe-zone respected; clearspace = icon side / 4; min size 24px.

## Typography

System sans (Roboto on Android) for zero bundled cost + full language coverage; optional bundled free
OFL font later. Scale uses Material 3 type scale. Mono for safety numbers. No paid fonts.

## Voice

Clear, calm, plain. No ads, no hype, no fear-mongering, no fake promises. Never claims to be
unhackable, never claims it has read message content, never claims a feature that isn't built.
Lowercase "Aster" in prose; brand red/orange accent used sparingly.

## Licensing of brand

App is open source (Apache-2.0 target). Brand name/logo reserved for the project; forks must rebrand.
