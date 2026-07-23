---
name: dependency-rules
description: Module dependency direction and api/impl visibility rules. Use when creating or modifying Gradle modules, adding module dependencies, or wiring Koin DI.
---

# Dependency Rules

* Modules depend only downward or on same-level
* `api` module never depends on `impl`
* Implementations have `internal` visibility and are provided via DI
* Each `impl` layer provides its own Koin module (e.g. `ArtistDataModule`).
* `shared/di/AppModule` assembles all modules
* Full per-layer dependency matrix (what each layer may/may not depend on) lives in the `feature-module-structure` skill — this file only covers the general direction rule and DI wiring
* Not build-enforced: convention plugins (`convention/.../plugins/base/*.kt`) wire shared infra only, they don't check feature-to-feature dependency direction, so violations of these rules can compile fine and must be caught in review

## DI aggregation hierarchy

```
shared/di/AppModule.kt
├── resourceModule()
├── coreModule()          — shared/di/CoreModule.kt
│   ├── storageModule()
│   ├── networkModule()
│   ├── ...
└── featureModule()       — shared/di/FeatureModule.kt
    ├── artistModule()    — shared/di/feature/ArtistModule.kt
    ├── albumModule()     — shared/di/feature/AlbumModule.kt
    ├── ...
```

* Each `shared/di/feature/<Feature>Module.kt` aggregates that one feature's own layer modules — `<feature>DataMapperModule()`, `<feature>DataModule()`, `<feature>DomainModule()`, `<feature>UIModule()`, and any `<component>ComponentModule()` — via `includes(...)`.
* `shared/di/FeatureModule.kt` aggregates every feature's `<feature>Module()` into one `featureModule()`.
* `shared/di/CoreModule.kt` aggregates `shared/core/*` infra modules (storage, crypto, network, service, datetime, db, toast, etc.) into `coreModule()` — the core-layer counterpart to `FeatureModule`.
