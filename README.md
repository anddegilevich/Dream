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

The development of project is still in progress.
However, even in its current state, it can still be a great example of Clean Architecture, and be a useful basis for any KMM project.

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

### ***Android***
  * App state preservation during configuration changes and process death;
  * Baseline profile and obfuscation optimisation;

## Stack

Here is the list of frameworks, that were used in this project:

* **Architecture** - [Decompose](https://arkivanov.github.io/Decompose), [MVIKotlin](https://arkivanov.github.io/MVIKotlin)
* **UI** - [Compose Multiplatform](https://www.jetbrains.com/compose-multiplatform)
* **Async** - [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
* **Serialization** - [Kotlin Serialization](https://github.com/Kotlin/kotlinx.serialization)
* **Gradle** - [Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html),
* **Dependency Injection** - [Koin](https://insert-koin.io)
  [Gradle Convention Plugins](https://docs.gradle.org/current/samples/sample_convention_plugins.html#compiling_convention_plugins),
  [Version Catalog](https://docs.gradle.org/current/userguide/version_catalogs.html),
  [KSP](https://github.com/google/ksp)
* **HTTP Client** - [Ktor](https://ktor.io)
* **Local Database** - [Room](https://developer.android.com/kotlin/multiplatform/room)
* **Preference Storage** - [KVault](https://github.com/Liftric/KVault)
* **Resources** - [MOKO resources](https://github.com/icerockdev/moko-resources)
* **Logger** - [Napier](https://github.com/AAkira/Napier)
* **Image Loading** - [Coil](https://github.com/coil-kt/coil)
* **Build Config** - [BuildKonfig](https://github.com/yshrsmz/BuildKonfig)
* **Static Code Analysis** - [Detekt](https://detekt.dev)

## Architecture

//TODO: Describe projects modules structure

## Setup

In order to build a project **CLIENT_ID** and **CLIENT_SECRET** of the API should be added to your `local.properties`.
Check [Spotify Web API Getting Started](https://developer.spotify.com/documentation/web-api/tutorials/getting-started#request-an-access-token) to learn how get them.
