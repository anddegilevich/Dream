---
name: ui-module-rules
description: UI layer module conventions — domain-to-UIData mappers and api/impl split in ui modules. Use when adding a mapper, model, or shared composable to a feature's ui/api or ui/impl module. For @Composable function/UIData authoring rules see compose-rules.
---

# UI Rules

* `ui/api` hosts: UI mapper interfaces, `UIData` models, `PreviewParameterProvider`s, and any composables/views meant for cross-feature reuse
* `ui/impl` hosts only mapper implementations (`internal class ...Impl`) — no state, no composables
* UI mapper naming: `interface <DomainModel>To<UIModel>Mapper : Mapper<DomainModel, UIModel>` in `ui/api`; `internal class <DomainModel>To<UIModel>MapperImpl` in `ui/impl`
* UI mappers are pure sync `map(item): UIModel` — no suspend, no side effects
* `UIData` models used in lists implement `Identified` + `companion object : EmptyFactory<...>` same pattern as domain core models
* See `compose-rules` for `UIData` naming/`@Immutable`/collection-type rules and `@Composable` function conventions
