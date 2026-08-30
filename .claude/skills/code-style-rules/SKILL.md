---
name: code-style-rules
description: General Kotlin code-style conventions applied across every module regardless of layer — param formatting, file layout, scope functions, member ordering, null-safety, sealed state modeling, naming. Use when writing or reviewing any Kotlin class/file, in addition to the layer-specific *-module-rules skill.
---

# Code Style Rules

* Constructor/method call with 2+ args: named args, one per line, trailing comma. Exception: positional-only Java/platform interop APIs (e.g. `KeyGenParameterSpec.Builder(...)`) keep no trailing comma
* One top-level class/interface/object per `.kt` file; file name matches the type name
* Use scope functions (`let`, `apply`, `run`, `also`, `with`) to avoid repeating a receiver/variable across consecutive calls on it
* Class-local constants used by only one class: `private val`/`private const val` inside a `private companion object` placed at the **end** of the class body
* Member order: properties → `init` → overridden/public functions → private helper functions → `private companion object` last
* No explicit `public` modifier. `internal` for impl classes (`internal class FooDomainComponent`), `private` for fields and companion members
* Boolean names use `is` prefix (`isLoading`, `isVisibleIme`)
* Avoid nullable properties and return types. Model an absent value as a non-null instance built by the type's `companion object : EmptyFactory<T>` (`empty()`); where "is this a real value or the empty stub?" matters, implement `EmptyState` on the type and branch on `isEmpty()`/`isNotEmpty()` rather than on `null`. Use `orEmpty(Factory)` (`foundation/abstraction/.../empty/factory/ext`) to collapse a nullable from an external/generated source. A result that can genuinely be absent or fail is expressed as `Result<T>`, never `T?`
* Storage/DAO observation is the one place a nullable may cross a signature: `Storage.observe(): Flow<T?>` / `readOrNull()` model "key not present", which is a real state of the store rather than a failure. The nullability is terminated at the data→domain boundary (`filterNotNull()` in the use case, or `orEmpty(Factory)`) and never appears in a `UseCase`, `Manager`, `State`, or `UIState` signature. A stream never carries `Result` per emission — absence is not an error, and failures belong in `catch {}`
* Null-safety via `?:` (Elvis) first choice; `requireNotNull`/`checkNotNull` only at platform boundaries (e.g. iosMain glue); never `!!`
* Sealed state modeling: `sealed interface` (not `sealed class`) for `Intent`/`SideEffect`; `data object` for parameterless singleton states, `data class` for parameterized ones
* Prefer single-expression functions (`fun foo() = ...`) for simple delegation, e.g. `private fun setLoading(isLoading: Boolean) = reduce { copy(isLoading = isLoading) }`
* Async data access never runs on the caller's (main) dispatcher: wrap a suspend call in `withContext(Dispatchers.IO) { ... }` and a `Flow` in `.flowOn(Dispatchers.IO)` before it is collected (e.g. `useCase().flowOn(Dispatchers.IO).onEach { ... }.launchIn(scope)`). Component/`DomainComponent` scopes are main-dispatched, so a repository, storage, database or network call left unwrapped blocks the UI thread
* Error handling: Kotlin `Result<T>` with `.onSuccess`/`.onFailure`/`.fold`, or the shared helpers in `shared/foundation/primitive/.../result/ResultExt.kt` (`foldResult`, `foldResultSuccess`, `recoverResult`) — not exceptions for expected/handled failure paths
* Never `throw` to signal a failure — return `Result.failure(<exception>)` instead, and keep `runCatching` at the boundary where a third-party/generated API throws (e.g. a network client), converting to `Result` immediately. `!!`, bare `throw`, and `getOrThrow()` in the middle of a flow are all the same mistake
* Extension functions live in a dedicated `<ReceiverType>Ext.kt` file under an `ext/` package next to the receiver, not inlined at the top of whatever file first uses them
* Imports: single alphabetically-sorted block, no blank-line grouping by vendor/package, no wildcard imports
* `TODO`/`STOPSHIP` comments are forbidden (detekt `ForbiddenComment`); use `FIXME` if a marker must be left in code
