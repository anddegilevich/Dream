---
name: data-mapper-module-rules
description: data/mapper module conventions — remote/local mapper interfaces, impls, DI wiring. Use when creating or modifying a class in a feature's data/mapper/api or data/mapper/impl module.
---

# Data Mapper Rules

* `data/mapper/api`: `interface <Source>To<Target>Mapper : Mapper<Source, Target>` — one interface per direction, no body (the `Mapper<From, To>` contract from `shared/foundation/abstraction/mapper` supplies `map(item)`/`map(items: Iterable/Sequence)`)
* `data/mapper/impl`: `internal class <Source>To<Target>MapperImpl : <Source>To<Target>Mapper`, `override fun map(item: Source): Target = with(item) { Target(...) }`
* Two directions per feature: remote `<Output>To<Data>Mapper` (API model → domain `Data`), local `<Data>To<Entity>Mapper` (domain `Data` → Room `Entity`)
* **Naming is decided by the mapper's target type, not by its source:**

  | Target | Interface name | Example |
  |---|---|---|
  | domain `<Method>Result` | `<X>ResponseToResultMapper` | `SearchResponseToResultMapper : Mapper<Search200Response, SearchResult>` |
  | domain `<X>Data` | `<X>OutputToDataMapper` | `SavedTrackOutputToDataMapper : Mapper<SavedTrackObject, SavedTrackData>` |
  | Room `<X>Entity` | `<X>DataToEntityMapper` | `TrackDataToEntityMapper : Mapper<TrackData, TrackEntity>` |

  `Response`/`Result` is reserved for the method-shaped pair — never write `<X>OutputToResultMapper` or `<X>ResponseToDataMapper`. A paged endpoint therefore splits in two: the page mapper is `<X>ResponseToResultMapper` (it owns `total`/paging), the item mapper it composes is `<X>OutputToDataMapper` (e.g. `SavedTracksResponseToResultMapper` injecting `SavedTrackOutputToDataMapper`)
* A method-shaped remote mapper maps a raw response type straight to a domain `<Method>Result` (e.g. `GetArtistAlbumsResponseToResultMapper : Mapper<PagingArtistDiscographyAlbumObject, GetArtistAlbumsResult>`) instead of returning an intermediate `Data` — used when the endpoint's shape (paging, totals) belongs in the `Result`, not the entity
* Simplified/partial model variants get their own sibling mapper (e.g. `SimplifiedArtistOutputToDataMapper`, `SimplifiedArtistDataToEntityMapper`) rather than overloading the full mapper
* Mapper impls compose other mappers via constructor injection + `.mapWith(mapper)` (singular) or `.mapWith(mapper)` on a `List`/`Iterable` (plural) — never map nested types by hand
* Cross-feature mapper reuse is allowed only through another feature's `data/mapper/api` (e.g. artist's mapper injecting `SimplifiedAlbumOutputToDataMapper` from `feature/album`) — never through a sibling `data/api`/`data/impl`
* Every mapper impl is bound in `<feature>DataMapperModule()` (`data/mapper/impl/di`): `factoryOf(::XImpl) bind X::class`

## Testing

* `MapperImpl` → `unit-test-rules`; fake any nested mapper dependencies inline in the test file (mapper interfaces are cheap to fake and rarely need cross-module reuse — only extract to a dedicated `test` module if another module genuinely needs the fake)
