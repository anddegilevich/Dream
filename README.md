# Dream

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)

**Dream** is a sample multimodal **Kotlin Multiplatform Mobile** app with shared **Compose Multiplatform** UI.<br>
It uses cutting-edge frameworks, patterns and plugins in order to achieve:

- Easily modified and reusable code base;
- Efficient and business-oriented development workflow;
- Shared Domain Logic and UI code for both mobile platforms (iOS and Android);
- High application productivity.

For this sample project [Spotify Web API](https://developer.spotify.com) is used to illustrate App and Rest API interaction.
Design is also inspired by [Spotify Mobile App](https://apps.apple.com/us/app/spotify-music-and-podcasts) and uses [Spotify Mobile UI Kit](https://www.figma.com/community/file/1052832340031141040/spotify-mobile-ui-kit)

## Features

### ***Common***
  * ~100 % of shared code between Android and iOS (all three layers: Data, Domain and UI);
  * Multimodal, clean project structure with safe dependencies (api/impl approach);
  * Static code analysis;
  * Shared localised resources; 
  * Multiplatform build config with multiple flavors;
  * Custom compose theme (with dark and light modes) for uniform and flexible UI;
  * //TODO Multiplatform widget;
  * //TODO Mock local rest api on Ktor;
  * //TODO Custom file templates for swift feature entities creation;

### ***Android***
  * App state preservation during configuration changes and process death;
  * Baseline profile and obfuscation optimisation;

## Technology Stack

Here is the list of frameworks, that were used in this project:

* **Architecture** - [Decompose](https://arkivanov.github.io/Decompose), [MVIKotlin](https://arkivanov.github.io/MVIKotlin)
* **UI** - [Compose Multiplatform](https://www.jetbrains.com/compose-multiplatform)
* **Async** - [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
* **Serialization** - [Kotlin Serialization](https://github.com/Kotlin/kotlinx.serialization)
* **Gradle** - [Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html),
  [Gradle Convention Plugins](https://docs.gradle.org/current/samples/sample_convention_plugins.html#compiling_convention_plugins),
  [Version Catalog](https://docs.gradle.org/current/userguide/version_catalogs.html),
  [KSP](https://github.com/google/ksp)
* **Dependency Injection** - [Koin](https://insert-koin.io)
* **HTTP Client** - [Ktor](https://ktor.io)
* **Local Database** - [Room](https://developer.android.com/kotlin/multiplatform/room)
* **Preference Storage** - [KVault](https://github.com/Liftric/KVault)
* **Resources** - [MOKO resources](https://github.com/icerockdev/moko-resources)
* **Logger** - [Napier](https://github.com/AAkira/Napier)
* **Image Loading** - [Coil](https://github.com/coil-kt/coil)
* **Build Config** - [BuildKonfig](https://github.com/yshrsmz/BuildKonfig)
* **Static Code Analysis** - [Detekt](https://detekt.dev)

## Architecture

```
|- 1. convention
|- 2. shared
| |- 2.1 foundation
| | |- 2.1.1 primitive
| | |- 2.1.2 serialization
| | |- ...
| |- 2.2 core
| | |- 2.2.1 config
| | |- 2.2.2 logger
| | |- ...
| |- 2.3 design
| | |- 2.3.1 theme
| | |- 2.3.2 system
| |- 2.4 template
| | |- 2.4.1 component
| | |- 2.4.2 source
| |- 2.5 feature
| | |- 2.5.1 artist
| | | |- 2.5.1.1 model
| | | | |- 2.5.1.1.1 artifact
| | | | |- 2.5.1.1.2 core
| | | |- 2.5.1.2 core
| | | |- 2.5.1.3 compose
| | | |- 2.5.1.4 component
| | | | |- 2.5.1.4.1 list
| | | | |- 2.5.1.4.2 details
| | | | |- ...
| | |- 2.5.2 album
| | |- ...
| |- 2.6 navigation
| |- 2.7 app
|- 3. android
| |- 3.1 app
| |- 3.2 baseline
|- 4. ios
```

### Structure Guidelines

- Project modules are following the one way hierarchy structure. 
Module can implement modules only from the same level it stands in or the levels below it.
- Everywhere where it is reasonable an api/impl approach for modules dependencies division should be used:<br>
***api*** - module that provides abstractions and primitives.
This module should implement as little dependencies as possible.
This module should be implemented in other modules so they don't depend on the actual implementation from impl module.<br>
***impl*** - module that implements api module's abstractions.
Public entities of this module should provide implementations with public constructors or modules for DI system.

### 1. convention

Module aggregates custom convention plugins for project's build.gradle.kts files optimisation.
Provided plugins are used for initializing multiplatform libraries, dependencies bundles and so on.

### 2. shared

Contains all the shared project code.

### 2.1 foundation

Project unspecific code.
Manipulates with primitives and external libraries.
Provides useful extensions for effective development.
Can be extracted to libraries.

***Examples:***
Primitives (Int, String, List,...) extensions;
Serializable extensions for unified json serialization;
KMP dispatcher for multiplatform coroutines;
...

### 2.2 core

Project specific foundation modules. 
Provide logic and models that can be used in any feature module.
All of the core modules are feature unspecific (doesn't depend on any feature at all or any in particular).

## Setup

In order to build a project **CLIENT_ID** and **CLIENT_SECRET** of the API should be added to your `local.properties`.
Check [Spotify Web API Getting Started](https://developer.spotify.com/documentation/web-api/tutorials/getting-started#request-an-access-token) to learn how get them.

//TODO: Add alternative instructions for mock build
