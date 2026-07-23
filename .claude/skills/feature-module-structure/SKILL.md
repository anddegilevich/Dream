---
name: feature-module-structure
description: Vertical-slice feature module layout, dependency matrix, and Koin naming convention. Use when creating a new feature module, or a new layer (data/domain/ui/component) inside an existing one.
---

# Feature Module Structure

Each feature (`artist`, `album`, etc.) follows vertical slice:

* `data/mapper/api|impl` - mappers from core remote and local models to domain
* `data/api|impl` - data access (repositories, remote sources, local sources, storages)
* `domain/model/artifact` - shared feature domain models (to avoid circular deps with other features)
* `domain/model/core` - feature domain models
* `domain/api|impl` - use cases, managers, validators, value holders, etc.
* `ui/api|impl` - ui models, compose functions, mappers from domain to ui models
* `component/<component_name>/api|impl` - screens/views
  * `api` - single marker interface extending `RenderComponent` (`@Composable fun Render()`); no state, intent or view types leak into api
  * `impl` - `ComponentImpl`, `DomainComponent`, `UIStateMapper`/state conservator, `component/model` (`Intent`, `SideEffect`, `UIState`, domain `State`), `preview` (preview component + providers), `view` (screen/layout composables, `view/semantic` test tags, `view/skeleton` loading placeholders)

## Dependency matrix

```
domain/model/artifact   → ALLOWED: foundation only
domain/model/core       → ALLOWED: domain/model/artifact (own), sibling feature data/model/artifact|core

data/api                → ALLOWED: domain/model/core (own)
                          NOT_ALLOWED: sibling feature data/*

data/mapper/api         → ALLOWED: domain/model/core (own)
                          NOT_ALLOWED: data/api, raw data types, domain/api, ui

data/mapper/impl        → ALLOWED: data/mapper/api (own), sibling feature data/mapper/api (reuse cross-feature mappers)

data/impl               → ALLOWED: data/api (own), data/mapper/api (own), core:service/db:api
                          NOT_ALLOWED: sibling feature data/* (enforced — no cross-feature data deps)

domain/api              → ALLOWED: data/api (own) as api() dep ← key: transitive for consumers, domain/model/core

domain/impl             → ALLOWED: domain/api (own) — gets data/api+Repository transitively, sibling feature domain/api
                          NOT_ALLOWED: sibling feature data/*, ui

ui/api                  → ALLOWED: domain/model/core, sibling feature ui/api ALLOWED (composable reuse), design:system

ui/impl                 → ALLOWED: ui/api (own), sibling feature data/mapper/api (shared domain to ui mappers)

ui/component/<s>/api    → ALLOWED: foundation:decompose

ui/component/<s>/impl   → ALLOWED: component/api (own), domain/api (own), sibling feature domain/api, sibling feature component/api
                          NOT_ALLOWED: data/*, ui/impl, sibling component/impl
```

## Key architectural decisions

1. **Repository interfaces in `data/api`**, implementations in `data/impl` — keeps data sources fully internal
2. **`domain/api` exposes `data/api` as `api()` dep** — consumers get Repository interface transitively; no duplicate dep declarations
3. **`domain/impl` never declares `data/api` directly** — gets it via transitive chain from `domain/api`
4. **`data/mapper/api` maps between domain model types only** (not raw data types) — keeps them safely reusable cross-feature without exposing internal data types
5. **`domain/model/artifact|core` have no `/api` suffix** — the module itself is the API (api-only, no impl)
6. **No sibling feature `data/*` imports anywhere** except `data/impl` for its own feature — cross-feature data access goes through domain module

## Koin module naming convention

```kotlin
// data/impl
fun <feature>DataModule() = module { ... }

// data/mapper/impl
fun <feature>DataMapperModule() = module { ... }

// domain/impl
fun <feature>DomainModule() = module { ... }

// ui/impl
fun <feature>UIModule() = module { ... }

// di/AppModule wiring:
internal fun <feature>Module() = module {
    includes(<feature>DataModule())
    includes(<feature>DataMapperModule())
    includes(<feature>DomainModule())
    includes(<feature>UIModule())
}
```

New DI-wired concerns (e.g. component instantiation) fold into the existing `<feature>Module()` file rather than a new cross-cutting aggregator — see `dependency-rules` skill.
