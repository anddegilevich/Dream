---
name: domain-module-rules
description: Domain layer conventions — use cases, managers. Use when creating or modifying a use case or domain manager. For domain/model (artifact/core) conventions see model-module-rules.
---

# Domain Rules

* One use case per operation: api interface `<Verb><Noun>UseCase` with `suspend operator fun invoke(params: <Method>Params): Result<<Method>Result>`; impl `internal class <Verb><Noun>UseCaseImpl` in `domain/impl`
* `<Method>Params`/`<Method>Result` are plain data classes under `domain/model/core/method/<methodName>/` (lowerCamel method name folder) — see `model-module-rules`
* Use case impl depends only on its own feature's `data/api` `Repository` (never `data/impl`, never a remote/local data source directly)
* Business logic (e.g. fetch-then-cache, composing multiple repository calls) lives in the use case, not the repository
* Long-lived domain-scoped mutable state (not request-shaped, not a use case) may use `ValueHolder`/`MutableValueHolder`/`AbstractMutableValueHolder` (`shared/foundation/abstraction/holder`) as base
