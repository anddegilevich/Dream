---
name: tdd-contract
description: Contract-first TDD workflow — establish the test contract before implementing, then implement until it passes. Use when implementing any new behavior — a use case, repository, data source, mapper, component, or screen. Defines when tests are written relative to code; for how to write them see unit-test-rules and ui-test-rules.
---

# Contract-First TDD

Tests are a contract agreed **before** implementation, not a description written after it. Four phases, each with an exit gate. Do not start a phase before the previous gate passes, and do not collapse phases into one pass.

This skill covers *when* and *in what order*. It does not restate how to write a test — that's `unit-test-rules` (fakes, assertions, KMP shared-instance hazard) and `ui-test-rules` (testTags, intent recorders). Load the relevant one in Phase 1.

## Phase 0 — Skeleton (types only, no behavior)

* Create only what the contract must compile against: `<Method>Params`/`<Method>Result` and data classes in `domain/model/core/api`, the `Repository` interface in `data/api`, the `<Verb><Noun>UseCase` interface in `domain/api`, `UIData` + mapper interfaces in `ui/api`, the `RenderComponent` marker in `component/<screen>/api`
* Every `impl` class exists with all members present and each body `= TODO()`. `TODO()` the function is fine — detekt's `ForbiddenComment` matches the `TODO` *comment*, and `unitTest` doesn't run detekt anyway (detekt hooks onto `check`)
* Decide signatures here, deliberately and out loud. A signature invented later, during implementation, is what drives contract drift
* **Gate:** no behavior written. Compilation is confirmed by Phase 1's run

## Phase 1 — Contract (the deliverable is tests, not code)

* Write the full test suite for the behavior per `unit-test-rules` / `ui-test-rules`
* Public-api fakes go in the sibling `test` module (`data/test`, `ui/test`, built with that layer's own **api** convention plugin); fakes of `internal` interfaces stay inline in the module's `commonTest`
* **Gate — one baseline run, and every test must be red:**
  ```bash
  ./gradlew unitTest      # all modules, host side
  ./gradlew uiTest        # only if component/impl was touched (iOS simulator)
  ```
* A test that passes against `TODO()` bodies is vacuous — delete it or strengthen it before continuing. This run is the whole reason the contract is trustworthy: it is the only point at which every test is *observed* failing before code exists
* Paste the real failure output. Never assert red without running
* **Then commit the contract** — `test(<feature>): contract for <behavior>`. That commit is the freeze point; git is the state machine, no tooling required

## Phase 2 — Implement

* Fill in the `TODO()` bodies until the contract passes
* **Do not edit any `*Test.kt` or `Fake*.kt` in a `test` module.** Run tests as often as useful — the constraint is on editing them, not running them
* If the contract is genuinely wrong (impossible signature, missing error case, wrong fixture type), that is a **contract amendment**: stop, say what is wrong and why, get approval, amend, re-run the baseline, re-commit. Quietly relaxing an assertion so the current implementation passes is not an amendment — it is the failure this workflow exists to prevent
* A test failing because the implementation is incomplete is not a reason to touch the test

## Phase 3 — Verify

```bash
./gradlew unitTest
./gradlew uiTest                      # if components touched
./gradlew detekt
git diff <contract-commit> -- '**/*Test.kt' '**/Fake*.kt'
```

* All green, and the diff empty — or every hunk in it an amendment approved in Phase 2
* Report the actual output. If something fails, say so with the failure text; a green claim without the run is worth nothing
