# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Commands

```bash
# Unit tests
./gradlew test
./gradlew allTests              # all targets, aggregated report

# Static analysis
./gradlew detekt

# Combined check
./gradlew check                 # detekt + tests

# Android
./gradlew :android:app:assembleDebug

# iOS (simulator)
xcodebuild build -project ios/app.xcodeproj -configuration Debug -scheme prodDebug -sdk iphonesimulator
```

**Run single test module:** `./gradlew :shared:feature:album:component:details:api:test`

**Local properties required** — create `local.properties` with Spotify credentials:
```
CLIENT_ID=<your_client_id>
CLIENT_SECRET=<your_client_secret>
```

Build flavors: `prod` (real Spotify API) and `mock`.

## Architecture

Kotlin Multiplatform (Compose Multiplatform UI shared across Android + iOS). MVI pattern with Decompose for navigation/component lifecycle.

### Module Layers (per feature)

Each feature (`artist`, `album`, `track`, `search`) follows this vertical slice:

```
model/artifact/api   — shared models (avoid circular deps)
model/core/api       — feature domain models
source/api|impl      — data access (Ktor remote, Room local)
domain/api|impl      — use cases
design/api|impl      — UI components + mappers
component/*/api|impl — screens (Decompose components)
```

### Key Shared Modules

- `shared/foundation/` — multiplatform primitives, base decompose components, compose utils
- `shared/core/` — infrastructure: HTTP client (Ktor), DB (Room), storage, crypto, toast
- `shared/design/` — theme (colors, typography, shapes), system UI components
- `shared/di/` — Koin DI wiring for all modules
- `shared/navigation/` — `AppNavigationComponent`, `ScreenConfig` sealed class
- `shared/app/` — `RootComponentImpl` (screen stack + toasts), iOS `RootViewController`
- `shared/config/` — BuildKonfig-based compile-time config per flavor

### Dependency Rule

Modules depend only downward/same-level. `api` module never depends on `impl`. `design` never depends on `component`.

### DI

Koin. Each layer provides its own module (e.g., `ArtistSourceModule`, `ArtistDomainModule`). `shared/di/AppModule` assembles all.

iOS init: `DIHelperKt.doInitDI()` called from `AppDelegate.swift`.

### Platform Entry Points

- **Android**: `DreamApplication` (Koin init) → `MainActivity` (RootComponent + Compose)
- **iOS**: `AppDelegate.swift` (DI) → `RootView.swift` (Decompose component display)
- **Shared**: `RootComponentImpl` manages screen stack and navigation

### Convention Plugins

`/convention/` contains Gradle convention plugins that wrap common build setup — `MultiplatformPlugin`, `ComposePlugin`, `KoinPlugin`, etc. Feature template plugins auto-configure new feature modules.

### Testing

Tests live in `commonTest` source sets. Framework: JUnit (`androidx.test.ext:junit`). Detekt config: `detekt/detekt.yml` (excludes generated code, ignores `@Composable` for LongMethod rule).
