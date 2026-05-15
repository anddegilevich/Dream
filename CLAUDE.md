# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build

### Commands

```bash
# Tests
./gradlew test # Unit tests
./gradlew detekt # Static analysis

# Build
./gradlew :android:app:assembleDebug # Android
xcodebuild build -project ios/app.xcodeproj -configuration Debug -scheme prodDebug -sdk iphonesimulator # iOS
```

### Flavors

* `prod` - Real Spotify API
* `mock` - Stub API

### Local properties

`local.properties` with Spotify credentials are required:

```
CLIENT_ID=<your_client_id>
CLIENT_SECRET=<your_client_secret>
```

## Architecture

### Tech stack

* **Architecture** - Decompose + MVI
* **UI** - Compose Multiplatform
* **Concurrency** - Kotlin Coroutines
* **Serialization** - Kotlin Serialization
* **Gradle** - Kotlin DSL, Gradle Convention Plugins, Version Catalog, KSP
* **Dependency Injection** - Koin
* **HTTP Client** - Ktor
* **Local Database** - Room
* **Preference Storage** - DataStore + Multiplatform Settings
* **Resources** - MOKO resources
* **Logger** - Napier
* **Image Loading** - Coil
* **Build Config** - BuildKonfig
* **Static Code Analysis** - Detekt

All versions can be found in version catalog file `/gradle/libs.versions.toml`

### Convention plugins

`/convention/` contains Gradle convention plugins that wrap common build setup (e.g., `MultiplatformPlugin`).
Feature template plugins (e.g., `TemplateComponentApiPlugin`) configure feature modules.

### Modules structure

* `shared/foundation/` - project unspecific extensions, abstractions, utils
  * `shared/foundation/primitive` - kotlin primitives extensions
  * `shared/foundation/serialization` - serialization utils
  * `shared/foundation/abstraction` - abstractions and base useful classes
  * `shared/foundation/compose` - Compose extensions
  * `shared/foundation/datetime` - datetime utils
  * `shared/foundation/decompose` - base decompose component implementations
* `shared/config` - flavor dependent build config
* `shared/logger` - project logger util
* `shared/resource/api|impl` - project strings, images, fonts, etc.
* `shared/core/` - project core infrastructure
  * `shared/core/crypto/api|impl` - crypto utils
  * `shared/core/client/api|impl` - http client
  * `shared/core/service/api|impl` - Spotify rest api service
  * `shared/core/db/api|impl` - local sql database
  * `shared/core/storage/api|impl` - preferences storage
* `shared/design/` - Compose design system
  * `shared/design/theme` - theme colors, typography, shapes, etc.
  * `shared/design/system` - ui components like buttons, inputs, etc.
* `shared/feature/` - feature modules
  * ...
* `shared/navigation/api|impl` - centralized app navigation
* `shared/di` - dependencies hub wiring all modules
* `shared/app/api|impl` - shared app entry point with root component and composable view

### Feature modules structure

Each feature (`artist`, `album`, etc.) follows vertical slice:

* `model/artifact` - shared feature domain models (to avoid circular deps with other features)
* `model/core` - feature domain models
* `data/api|impl`- data access (remote, local, storage), mappers to domain models
* `domain/api|impl` - use cases, managers, validators, value holders, etc.
* `design/api|impl` - ui models, compose functions, mappers from to ui models
* `component/<component_name>/api|impl` - screens/views (component, component models, compose functions)

### Platform entry points

* **Android**: `DreamApplication` → `MainActivity`
* **iOS**: `iOSApp` → `RootView`
* **Shared**: `ComposeApp` → `RootComponentImpl`

## Rules

### Dependencies rules

* Modules depend only downward or on same-level
* `api` module never depends on `impl`
* Implementations have `internal` visibility and provided via DI
* Each `impl` layer provides its own module (e.g., `ArtistSourceModule`).
  `shared/di/AppModule` assembles all modules.

### Compose rules

#### UI models rules

* UI models names ended with `UIData`. Only exception is state models of MVI components (end with `UIState`)
* UI models annotated with `Immutable` or `Stable`
* UI models do not depend on domain models
* Collection parameters of ui models should be `ImmutableList` instead of `List`
* `LazyList` items models should have `Identifier`

#### Compose functions rules

* First optional parameter should be `Modifier`
* Use animations to change visibility/color/position/other render values (e.g., `animateFloatAsState`)
* MVI pattern is mostly preferable: 
  - Single state defining parameter `data: UIData`
  - Single lambda intent handler `onIntent: (Intent) -> Unit`
* Use `LabeledPreviewParameterProvider` for composables `Preview`

### Component rules

* DomainComponent plays view model role (handle view intents, makes requests, manages domain state)
* Domain State maps to UIState in BinderComponent using UIStateMapper
* Domain State and all its parameters should be `Serializable`

### Test rules

#### UI test rules

* Map UI elements with Compose Semantics `testTags`
* UI tests should check all view states provided by `PreviewParameterProvider`