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