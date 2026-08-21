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
* Null-safety via `?:` (Elvis) first choice; `requireNotNull`/`checkNotNull` only at platform boundaries (e.g. iosMain glue); never `!!`
* Sealed state modeling: `sealed interface` (not `sealed class`) for `Intent`/`SideEffect`; `data object` for parameterless singleton states, `data class` for parameterized ones
* Prefer single-expression functions (`fun foo() = ...`) for simple delegation, e.g. `private fun setLoading(isLoading: Boolean) = reduce { copy(isLoading = isLoading) }`
* Error handling: Kotlin `Result<T>` with `.onSuccess`/`.onFailure`/`.fold`, or the shared helpers in `shared/foundation/primitive/.../result/ResultExt.kt` (`foldResult`, `foldResultSuccess`) — not exceptions for expected/handled failure paths
* Extension functions live in a dedicated `<ReceiverType>Ext.kt` file under an `ext/` package next to the receiver, not inlined at the top of whatever file first uses them
* Imports: single alphabetically-sorted block, no blank-line grouping by vendor/package, no wildcard imports
* `TODO`/`STOPSHIP` comments are forbidden (detekt `ForbiddenComment`); use `FIXME` if a marker must be left in code
