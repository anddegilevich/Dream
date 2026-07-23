---
name: data-module-rules
description: Data layer conventions — repositories, remote/local data sources. Use when creating or modifying a Repository, RemoteDataSource, or LocalDataSource class. For data/mapper module conventions see data-mapper-module-rules.
---

# Data Rules

* `data/api` `Repository` interface exposes `suspend fun <method>(params: <Method>Params): Result<<Method>Result>` mirroring domain method models, plus void cache methods (`cacheX`)
* `data/impl` `<Feature>RepositoryImpl` (`internal class`) only routes to `<Feature>RemoteDataSource`/`<Feature>LocalDataSource` — no business logic (that belongs in the use case)
* Remote/local data sources: `internal interface <Feature>RemoteDataSource`/`LocalDataSource` + `internal class ...Impl`, extending `BaseRemoteDataSource`/`BaseLocalDataSource` (`shared/feature/base/data/impl`) for `apiService`/`database` access
* Remote data source wraps API calls: `runCatching { api.call(...).body() }.foldResultSuccess { response -> ... }`, mapping the response via a `data/mapper/api` mapper (see `data-mapper-module-rules`)
* Local data source maps domain model → Room entity through a `data/mapper/api/local` mapper (see `data-mapper-module-rules`) before DAO upsert/query
* No sibling-feature `data/api`/`data/impl` imports — cross-feature data reached through the sibling `domain/api`; sibling `data/mapper/api` reuse is the sole exception (see `feature-module-rules`)
