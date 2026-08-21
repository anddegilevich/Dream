---
name: feature-module-rules
description: Vertical-slice feature module layout, dependency matrix, and Koin naming convention. Use when creating a new feature module, or a new layer (data/domain/ui/component) inside an existing one.
---

# Feature Module Structure

Each feature (`artist`, `album`, etc.) follows vertical slice:

* `data/mapper/api|impl` - mappers from core remote and local models to domain
* `data/api|impl` - data access (repositories, remote sources, local sources, storages)
* `domain/model/artifact/api|test` - shared feature domain models (to avoid circular deps with other features); `test` holds fixtures, safe for cross-feature reuse
* `domain/model/core/api|test` - feature domain models; `test` holds fixtures, own-feature scoped
* `domain/api|impl` - use cases, managers, validators, value holders, etc.
* `ui/api|impl` - ui models, compose functions, mappers from domain to ui models
* `component/<component_name>/api|impl` - screens/views
  * `api` - single marker interface extending `RenderComponent` (`@Composable fun Render()`); no state, intent or view types leak into api
  * `impl` - `ComponentImpl`, `DomainComponent`, `UIStateMapper`/state conservator, `component/model` (`Intent`, `SideEffect`, `UIState`, domain `State`), `preview` (preview component + providers), `view` (screen/layout composables, `view/semantic` test tags, `view/skeleton` loading placeholders)

## Dependency matrix

```
domain/model/artifact/api   → ALLOWED: foundation only
domain/model/artifact/test  → ALLOWED: domain/model/artifact/api (own) as api() dep — safe for cross-feature reuse (artifact/api graph is a leaf-terminated DAG, can never cycle)
domain/model/core/api       → ALLOWED: domain/model/artifact/api (own), sibling feature domain/model/artifact/api|core/api
domain/model/core/test      → ALLOWED: domain/model/core/api (own), domain/model/artifact/test (own) as api() deps — own-feature scoped; a cross-feature core/test dependency must follow the same single direction already established by the core/api graph (never the reverse), to avoid a real Gradle circular-project-dependency

data/api                → ALLOWED: domain/model/core/api (own)
                          NOT_ALLOWED: sibling feature data/*

data/mapper/api         → ALLOWED: domain/model/core/api (own)
                          NOT_ALLOWED: data/api, raw data types, domain/api, ui

data/mapper/impl        → ALLOWED: data/mapper/api (own), sibling feature data/mapper/api (reuse cross-feature mappers)

data/impl               → ALLOWED: data/api (own), data/mapper/api (own), core:service/db:api, sibling feature data/mapper/api (reuse cross-feature mappers)
                          NOT_ALLOWED: sibling feature data/api|impl (enforced — no cross-feature data deps)

domain/api              → ALLOWED: data/api (own) as api() dep ← key: transitive for consumers, domain/model/core/api

domain/impl             → ALLOWED: domain/api (own) — gets data/api+Repository transitively, sibling feature domain/api
                          NOT_ALLOWED: sibling feature data/*, ui

ui/api                  → ALLOWED: domain/model/core/api, sibling feature ui/api ALLOWED (composable reuse), design:system

ui/impl                 → ALLOWED: ui/api (own), domain/model/core/api|artifact/api (own), sibling feature ui/api (reuse)

ui/component/<s>/api    → ALLOWED: foundation:decompose

ui/component/<s>/impl   → ALLOWED: component/api (own), ui/api (own + sibling), domain/api (own), sibling feature domain/api, sibling feature component/api
                          NOT_ALLOWED: data/*, ui/impl, sibling component/impl

data/test               → ALLOWED: data/api (own) as api() dep
ui/test                 → ALLOWED: ui/api (own) as api() dep, domain/model/artifact/api|core/api (own, if the api's interfaces reference those types)
domain/test             → ALLOWED: domain/api (own) as api() dep
```

`<layer>/test` modules are sibling to that layer's `api`/`impl`, built with the same convention plugin as that layer's own `api` module (e.g. `data/test` uses `project.feature.data.api`, `ui/test` uses `project.feature.ui.api`, model `test` uses `project.feature.model`) — there is no dedicated test plugin. They host hand-rolled fakes of that layer's own public `api` interfaces, consumed exclusively via `commonTest` dependencies (never `commonMain`) by `impl` modules that need the fake — including cross-feature (same carve-out as `data/mapper/api` reuse). Only created when there's an actual consumer — no speculative empty `test` modules. See `unit-test-rules`.

## Key architectural decisions

1. **Repository interfaces in `data/api`**, implementations in `data/impl` — keeps data sources fully internal
2. **`domain/api` exposes `data/api` as `api()` dep** — consumers get Repository interface transitively; no duplicate dep declarations
3. **`domain/impl` never declares `data/api` directly** — gets it via transitive chain from `domain/api`
4. **`data/mapper/api` maps between domain model types only** (not raw data types) — keeps them safely reusable cross-feature without exposing internal data types
5. **`domain/model/artifact|core` have no `impl` submodule** — only `api` (the model contract) and, when there's a consumer, `test` (fixtures); no speculative empty `test` modules
6. **No sibling feature `data/api`|`data/impl` imports anywhere** except `data/impl` for its own feature — cross-feature data access goes through domain module (sibling `data/mapper/api` reuse is the one carved-out exception, for both `data/impl` and `data/mapper/impl`)
7. **Matrix is convention-only, not build-enforced** — convention plugins (`convention/.../plugins/base/*.kt`) only wire shared infra deps, they don't check feature-to-feature dependency direction. Violations can slip in (e.g. a feature's `domain/impl` pulling another feature's `data/api` directly) and must be caught in review.

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
