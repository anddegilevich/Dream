---
name: ui-test-rules
description: Compose UI test conventions. Use when writing Compose UI tests or semantics testTags.
---

# UI Test Rules

## Rendering

* Map UI elements with Compose Semantics `testTags` — every element a test needs to *find*, including every interactive one, not only the elements asserted for rendering
* UI tests should check all view states provided by `PreviewParameterProvider`
* Test class per composable (`<Composable>Test`), in the same package, in that module's `commonTest`
* Runner `kotlin.test.Test`, `androidx.compose.ui.test.v2.runComposeUiTest`, content wrapped in `ComposeAppTheme`
* Test names: backticked `action - expected outcome`

## Intent generation

* Every `onIntent(...)` call site in a `view/` composable needs a test that performs the real user action and asserts the emitted `Intent` — both its identity and its payload. A rendering assertion alone does not cover it
* Record intents with a `mutableListOf<Intent>()` declared **inside** the `@Test` body, passed as `intents::add`. Never a class-level field: `kotlin.test` on Kotlin/Native runs every `@Test` of a class against one shared instance, so a class-level recorder leaks across tests (and `iosSimulatorArm64` is the only target UI tests run on)
* The shared `setContent` helper takes `onIntent: (Intent) -> Unit = {}` so render-only tests stay short
* Assert with Kotest `shouldContainExactly` — it pins the exact emitted sequence, catching duplicate emissions that `shouldContain` would miss
* Render-only tests assert `intents.shouldBeEmpty()` — a cheap guard against an intent fired from composition (a misplaced `LaunchedEffect`)
* Follow every action with `waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }`. `clickableWithDebounce` dispatches `onClicked()` from a launched coroutine, so the intent lands a frame after `performClick()` returns. `conditionDescription` is what makes a dropped intent read as a named timeout instead of a bare `ComposeTimeoutException`
* For a list, act on an item that is **not** the first (`onAllNodes(item)[1]`) and assert against that item's id — clicking index 0 passes even when the id is hardcoded to the first element
* Derive expected payloads from the same `PreviewParameterProvider` the state came from, never hardcoded literals
* Text fields: prefer `performTextReplacement` over `performTextInput`. Preview states seed a non-empty value and the cursor starts at index 0, so `performTextInput` prepends. The replacement text must differ from the seeded value — `SearchTextField`'s `String` overload swallows a no-op edit

Example: `shared/feature/search/component/search/impl/src/commonTest/.../view/SearchScreenTest.kt`
