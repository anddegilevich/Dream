---
name: component-rules
description: Decompose component conventions. Use when creating or modifying a Decompose component (ComponentImpl, DomainComponent, UIState/Intent/SideEffect, component api/impl split).
---

# Component Rules

* `DomainComponent` plays view model role (handle view intents, makes requests, manages domain state)
* Domain State maps to `UIState` in `BinderComponent` using `UIStateMapper`
* Domain State and all its parameters should be `Serializable`
* Component `api` module exposes only a `RenderComponent`-extending marker interface (`Render()`); it has no other members and no dependency on UI/design/state types
* `UIState`, `Intent`, `SideEffect`, `ComponentImpl`, `DomainComponent`, `UIStateMapper`, preview components/providers and all view composables live in the component's `impl` module
* Use `BaseComponent`/`BaseBinderComponent`/`BaseDomainComponent` (`shared/feature/base/component/impl`) as base classes for new components
