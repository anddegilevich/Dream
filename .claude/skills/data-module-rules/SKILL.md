---
name: data-module-rules
description: Data layer conventions — repositories, remote/local data sources. Use when creating or modifying a Repository, RemoteDataSource, or LocalDataSource class. For data/mapper module conventions see data-mapper-module-rules.
---

# Data Rules

* `data/api` `Repository` interface exposes `suspend fun <method>(params: <Method>Params): Result<<Method>Result>` mirroring domain method models, plus void cache methods (`cacheX`)
* `data/impl` `<Feature>RepositoryImpl` (`internal class`) only routes to `<Feature>RemoteDataSource`/`<Feature>LocalDataSource` — no business logic (that belongs in the use case)
* Remote/local data sources: `internal interface <Feature>RemoteDataSource`/`LocalDataSource` + `internal class ...Impl`; `apiService: ApiService`/`database: AppDatabase` are plain constructor params (own `private val`), resolved by Koin's `singleOf(::XImpl)` from the graph — no `KoinComponent`/`by inject()`, no shared base class
* Remote data source wraps API calls: `runCatching { api.call(...).body() }.foldResultSuccess { response -> ... }`, mapping the response via a `data/mapper/api` mapper (see `data-mapper-module-rules`)
* Local data source maps domain model → Room entity through a `data/mapper/api/local` mapper (see `data-mapper-module-rules`) before DAO upsert/query
* No sibling-feature `data/api`/`data/impl` imports — cross-feature data reached through the sibling `domain/api`; sibling `data/mapper/api` reuse is the sole exception (see `feature-module-rules`)

## Testing

* `RepositoryImpl`, `RemoteDataSourceImpl`, `LocalDataSourceImpl` → all `unit-test-rules`: fake their dependencies (`RemoteDataSource`/`LocalDataSource` for the repository, a `MockEngine`-backed API client for the remote data source, the DAOs directly for the local data source)
* A feature's `Repository` fake (e.g. `FakeAlbumRepository`) lives in a sibling `data/test` module (`project.feature.data.api` plugin, same as `data/api`) so `domain/impl` (own or cross-feature) can consume it as a `commonTest` dependency — see `unit-test-rules`. Fakes of `RemoteDataSource`/`LocalDataSource`/DAOs (internal to `data/impl`) stay inline in that module's own `commonTest`
