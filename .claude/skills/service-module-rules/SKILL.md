---
name: service-module-rules
description: core/service module conventions — generated Spotify API client, ApiService, auth/token handling. Use when creating or modifying ApiService, a *Api usage, or the token/auth client in shared/core/service.
---

# Service Rules

* `core/service/api/.../generated/` (`api/`, `model/`) is OpenAPI-codegenerated from the Spotify spec via `./gradlew :shared:core:service:api:openApiGenerate` (`/open-api-generate`) — never hand-edit files under `generated/`; changes come from regenerating
* `ApiService` (`core/service/api`) is a plain interface exposing one `val <name>Api: <Name>Api` per generated API client (e.g. `artistsApi`, `albumsApi`, `tracksApi`, `searchApi`) — feature remote data sources depend on this interface only, never instantiate a generated `*Api` class themselves
* `ApiServiceImpl` (`core/service/impl`, `internal class`) builds one shared Ktor `HttpClient` off `RemoteClient` with `DefaultRequest` (base URL) + `Auth { bearer { loadTokens / refreshTokens } }` installed once, then constructs each `by lazy { XApi(baseUrl = ..., httpClient = apiServiceClient) }` off that shared client — don't create a separate `HttpClient` per API
* Bearer refresh flow: `loadTokens` reads from `TokensStorage`; `refreshTokens` calls `TokenService.getToken()` and persists the result via `tokensStorage.save(tokens)` before mapping to the bearer pair
* `TokenService`/`TokenServiceImpl` (`internal`) is a narrow client for the OAuth token endpoint only — separate `HttpClient` config (its own base URL), `runCatching { client.post { ... }.body<TokenResponse>() }`, request constants (header/param names) as `private companion object` consts, never magic strings inline
* `TokensStorage`/`TokensStorageImpl` persists `Tokens`; mapping between wire `TokenResponse` and domain `Tokens` goes through `TokensMappers`, not inline construction
* Everything in `core/service/impl` (`ApiServiceImpl`, `TokenServiceImpl`, `TokensStorageImpl`) is `internal`, bound in `serviceModule()` via `singleOf(::XImpl) bind X::class`
* Feature-level repositories/data sources never import `core/service/impl` — only `core/service/api`'s `ApiService` and the generated `api`/`model` types (see `data-module-rules`, `data-mapper-module-rules`)
