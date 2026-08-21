---
name: model-module-rules
description: domain/model module conventions — artifact vs core models, ids, dictionaries, method params/result, fixture modules. Use when creating or modifying a class in a feature's domain/model/artifact/api|test or domain/model/core/api|test module.
---

# Model Rules

* `domain/model/artifact/api` — shared cross-feature contracts only:
  * abstraction interfaces extending `Identified` (e.g. `ArtistInfo`) declaring the fields every variant of the entity shares
  * id value classes: `@JvmInline @Serializable value class <X>Id(override val value: String) : Identifier`, `companion object : EmptyFactory<...> { override fun empty() = <X>Id(value = "") }`
  * dictionary enums: `@Serializable enum class <X>Type(override val id: AnyIdentifier) : Identified`, entries built with `identifier("...")`, always include an `UNKNOWN` entry as the safe default
  * simplified/partial data variants (e.g. `SimplifiedArtistData`) live here too when reused across features, following the same shape as `domain/model/core/api` data classes below
* `domain/model/core/api` — feature-local models:
  * full data classes implement the feature's `artifact/api` abstraction, extend `AbstractIdentified()`, annotated `@Serializable`, with `companion object : EmptyFactory<...> { override fun empty() = ... }`
  * `<Method>Params`/`<Method>Result` are plain (non-`Serializable`, no `EmptyFactory`) data classes under `method/<methodName>/` (lowerCamel method name folder) — one pair per use case/repository method
  * `<Method>Params` holds only the inputs a method needs (ids, paging `limit`/`offset`, etc.); `<Method>Result` holds the shaped output, which may reference another feature's `domain/model/artifact/api` type directly (e.g. `GetArtistAlbumsResult` referencing `SimplifiedAlbumData` from `feature/album`) — that's the sanctioned form of cross-feature model reuse
* `domain/model/artifact/test` / `domain/model/core/test` — fixture modules, sibling to `api`, only created when there's an actual consumer (no speculative empty modules): a lowerCamel factory function per type (e.g. `fun simplifiedAlbumData(id: String, artists: List<SimplifiedArtistData>, ...): SimplifiedAlbumData = ...`), package matching the type it builds. `artifact/test` depends only on its own `artifact/api`; `core/test` depends on its own `core/api` and, when a core-level fixture needs to build a field typed as its own `artifact/api` model (e.g. `GetNewReleasesResult.albums: List<SimplifiedAlbumData>`), also its own `artifact/test` — mirroring the `core/api → artifact/api` (own) edge one layer up. Never reach into a sibling feature's `core/test` (that's how a real cross-module cycle happens, since `core/api` already allows cross-feature `core → core` edges in one direction; `artifact/test` is always safe to reuse cross-feature because the `artifact/api` graph is a leaf-terminated DAG, `core/test` is not guaranteed to be)
* All ids implement `Identifier` (`value: String`, `isEmpty()`); all identifiable models implement `Identified`/`AbstractIdentified()` so id-keyed collections and `LazyList` keys work uniformly
* Enum-by-id lookup uses `getEnumValueByIdOrElse(id = ...) { Fallback }` (`shared/foundation/abstraction/id/ext`), not manual `when`/`firstOrNull` — see `data-mapper-module-rules` for where this is typically called (mapping a raw API enum value into a dictionary type)

## Testing

* `domain/model/artifact/api`/`domain/model/core/api` are out of scope for unit tests — these are pure data holders with no branching logic (the `when`/fallback logic that maps *into* them lives in a mapper, tested there per `data-mapper-module-rules`)
* `domain/model/artifact/test`/`domain/model/core/test` are fixture modules, not test suites themselves — no unit tests inside them either, they're consumed via `commonTest` by other layers' `impl` modules (see `feature-module-rules`)
