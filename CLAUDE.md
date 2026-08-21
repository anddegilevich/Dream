# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build

### Commands

Use the commands from `.claude/commands/`.

### Flavors

* `prod` - Real Spotify API
* `mock` - Stub API

### Local properties

`local.properties` with Spotify credentials are required:

```
CLIENT_ID=<your_client_id>
CLIENT_SECRET=<your_client_secret>
```

## Architecture

### Convention plugins

`/convention/` contains Gradle convention plugins that wrap common build setup (e.g., `MultiplatformPlugin`).
Feature base plugins (e.g., `BaseComponentApiPlugin`) configure feature modules.

### Feature modules structure

See the `feature-module-rules`

### Platform entry points

* **Android**: `DreamApplication` → `MainActivity`
* **iOS**: `iOSApp` → `RootView`
* **Shared**: `RootComponentImpl` → `ComposeApp` (`RootComponentImpl.Render()` renders the internal `ComposeApp` composable; platforms call `rootComponent.Render()` directly, no composable wrapper is exposed)

## Workflow

* Always ask if any clarifications needed.
* Do not suggest or execute git methods until specifically asked for it.

### Incremental delivery

Every task is decomposed into steps and executed one step at a time.

1. **Plan first.** Before writing any code, present the full step list — one line per step, in execution order, each step independently reviewable.
2. **Confirm before each step.** Wait for explicit approval before starting a step. Approval of the plan is not approval of the steps; approval of one step is not approval of the next.
3. **One step per turn.** Finish the step, report what changed, then stop and wait. Do not chain steps, and do not start the next step "while waiting".
4. **Re-confirm on deviation.** If a step turns out to need work outside its stated scope, stop and re-confirm instead of widening it.

### Feature implementation order

A feature is built layer by layer, bottom-up, and each layer is split into an `api` step and an `impl` step:

```
domain/model  →  data/mapper  →  data  →  domain  →  ui  →  component  →  DI wiring
```

* For each layer: create the `api` module first (interfaces, models, signatures) as its own step. That contract gets confirmed before the matching `impl` step starts.
* An unconfirmed contract blocks its `impl` — do not write `impl` code "provisionally" against a contract still under review.
* Contract changes discovered during `impl` are an amendment: stop, state what is wrong and why, get approval. See `tdd-contract` Phase 2.
* Layer ordering and dependency direction come from `feature-module-rules`; the test-vs-code ordering inside a step comes from `tdd-contract`.
