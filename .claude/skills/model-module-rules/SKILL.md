---
name: model-module-rules
description: domain/model module conventions — artifact vs core models, ids, dictionaries, method params/result. Use when creating or modifying a class in a feature's domain/model/artifact or domain/model/core module.
---

# Model Rules

* `domain/model/artifact` — shared cross-feature contracts only, no `/api` suffix (the module itself is the api, api-only, no impl):
  * abstraction interfaces extending `Identified` (e.g. `ArtistInfo`) declaring the fields every variant of the entity shares
  * id value classes: `@JvmInline @Serializable value class <X>Id(override val value: String) : Identifier`, `companion object : EmptyFactory<...> { override fun empty() = <X>Id(value = "") }`
  * dictionary enums: `@Serializable enum class <X>Type(override val id: AnyIdentifier) : Identified`, entries built with `identifier("...")`, always include an `UNKNOWN` entry as the safe default
  * simplified/partial data variants (e.g. `SimplifiedArtistData`) live here too when reused across features, following the same shape as `domain/model/core` data classes below
* `domain/model/core` — feature-local models:
  * full data classes implement the feature's `artifact` abstraction, extend `AbstractIdentified()`, annotated `@Serializable`, with `companion object : EmptyFactory<...> { override fun empty() = ... }`
  * `<Method>Params`/`<Method>Result` are plain (non-`Serializable`, no `EmptyFactory`) data classes under `method/<methodName>/` (lowerCamel method name folder) — one pair per use case/repository method
  * `<Method>Params` holds only the inputs a method needs (ids, paging `limit`/`offset`, etc.); `<Method>Result` holds the shaped output, which may reference another feature's `domain/model/artifact` type directly (e.g. `GetArtistAlbumsResult` referencing `SimplifiedAlbumData` from `feature/album`) — that's the sanctioned form of cross-feature model reuse
* All ids implement `Identifier` (`value: String`, `isEmpty()`); all identifiable models implement `Identified`/`AbstractIdentified()` so id-keyed collections and `LazyList` keys work uniformly
* Enum-by-id lookup uses `getEnumValueByIdOrElse(id = ...) { Fallback }` (`shared/foundation/abstraction/id/ext`), not manual `when`/`firstOrNull` — see `data-mapper-module-rules` for where this is typically called (mapping a raw API enum value into a dictionary type)
