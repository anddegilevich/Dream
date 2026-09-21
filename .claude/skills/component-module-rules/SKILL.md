---
name: component-module-rules
description: Decompose component conventions. Use when creating or modifying a Decompose component (ComponentImpl, DomainComponent, UIState/Intent/SideEffect, component api/impl split).
---

# Component Rules

* `DomainComponent` plays view model role (handle view intents, makes requests, manages domain state)
* Domain State maps to `UIState` in `BinderComponent` using `UIStateMapper`
* Domain State and all its parameters should be `Serializable`
* Component `State` classes declare no default parameter values — every initial value is supplied by the component's `ComponentStateConservator.initialState`, so restored and fresh state come from one place
* Component `api` module exposes exactly two types: a `RenderComponent`-extending marker interface (`Render()`) and its `<Name>ComponentFactory`; the marker has no other members, and neither has a dependency on UI/design/state types
* A component is created only through its factory — `<Name>ComponentFactory.create(componentContext)`, plus `navArgs` when the screen takes them. The component type itself is never a Koin definition and is never resolved with `get()`/`parametersOf()`; parents `by inject()` the factory. See `feature-module-rules` for the module registration form
* `<Name>ComponentFactoryImpl` is `internal`, lives next to `ComponentImpl` in `impl/component`, and only forwards its arguments to the constructor — it holds no dependencies of its own (`DomainComponent` still injects those itself)
* `UIState`, `Intent`, `SideEffect`, `ComponentImpl`, `DomainComponent`, `UIStateMapper`, preview components/providers and all view composables live in the component's `impl` module
* Use `BaseComponent`/`BaseBinderComponent`/`BaseDomainComponent` (`shared/feature/base/component/impl`) as base classes for new components
