---
name: spotify-api-rules
description: Spotify Web API usage rules — spec as source of truth, OAuth flow, redirect URIs, scopes, token handling, 429/backoff, deprecated endpoints, error handling, Developer Terms (caching, attribution). Use when adding or changing a Spotify endpoint call, auth/scope/redirect config, retry/error handling, or local caching of Spotify content.
---

# Spotify Web API Rules

Source: Spotify for Developers recommended AI-assistant prompt.

## Spec

* OpenAPI spec `https://developer.spotify.com/reference/web-api/open-api-schema.yaml` is the source of truth for endpoint paths, params, response schemas — never guess endpoints or field names
* Project generates the client from it (`shared/core/service/api/build.gradle.kts`, `/open-api-generate`); check generated `api/`/`model/` types before assuming an endpoint or field exists (see `service-module-rules`)

## Authorization

* User-specific data → Authorization Code with PKCE (`https://developer.spotify.com/documentation/web-api/tutorials/code-pkce-flow`); plain Authorization Code (`.../tutorials/code-flow`) only with a secure backend
* Client Credentials only for public, non-user data
* Never Implicit Grant (deprecated)
* Client Secret never in client-side code — app is a mobile client, so no secret in source, `local.properties`, or build config

## Redirect URIs

* HTTPS only, except `http://127.0.0.1` for local dev
* Never `http://localhost`, never wildcard URIs
* Requirements: `https://developer.spotify.com/documentation/web-api/concepts/redirect_uri`

## Scopes

* Request minimum scopes needed by implemented features — no preemptive broad scopes
* Adding a feature that needs a new scope → add that scope with the feature, not before
* Reference: `https://developer.spotify.com/documentation/web-api/concepts/scopes`

## Tokens

* Store tokens securely (`TokensStorage`)
* Implement refresh (`https://developer.spotify.com/documentation/web-api/tutorials/refreshing-tokens`)
* Refresh token expired/rejected → send user through authorization again, don't loop on refresh

## Rate limits

* HTTP 429 → respect `Retry-After` header, exponential backoff
* Never retry immediately or in tight loops
* Implemented once in `ServiceRequestRetryConfiguratorImpl` (`core/service/impl`), injected into `ApiServiceImpl` + `TokenServiceImpl` — `HttpRequestRetry`, 429 only, max 3 retries, wait = max(`Retry-After`, exponential backoff + jitter), `Retry-After` > 30s fails fast; never add per-feature retry

## Deprecated endpoints

* Never use deprecated endpoints (check `deprecated: true` in spec)
* `/playlists/{id}/items` over `/playlists/{id}/tracks`
* `/me/library` over type-specific library endpoints

## Error handling

* Handle every HTTP error code documented in the spec for the endpoint
* Read returned error message, surface meaningful feedback to user — don't swallow into generic failure

## Developer Terms (`https://developer.spotify.com/terms`)

* No caching Spotify content beyond what's needed for immediate use — applies to Room (`db-module-rules`) and local data sources
* Always attribute content to Spotify in UI
* Never use API data to train ML models
