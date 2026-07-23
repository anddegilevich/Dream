---
name: compose-rules
description: UI model and Compose function conventions. Use when writing or reviewing @Composable functions, UI models (UIData), or previews.
---

# Compose Rules

## UI models rules

* UI models names ended with `UIData`. Only exception is state models of MVI components (end with `UIState`)
* UI models annotated with `Immutable` or `Stable`
* UI models do not depend on domain models
* Collection parameters of ui models should be `ImmutableList` instead of `List`
* `LazyList` items UI models should have `Identifier` as their `key`

## Compose functions rules

* First optional parameter should be `Modifier`
* Use animations to change visibility/color/position/other render values (e.g., `animateFloatAsState`)
* MVI pattern is mostly preferable:
  - Single state defining parameter `data: UIData`
  - Single lambda intent handler `onIntent: (Intent) -> Unit`
* Use `LabeledPreviewParameterProvider` for composables `Preview`
