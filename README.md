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
  * //TODO Mock local rest api on Ktor;
  * //TODO Custom file templates for convenient feature entities creation;
  * //TODO Multiplatform widget;

### ***Android***
  * App state preservation during configuration changes and process death;
  * Baseline profile and obfuscation optimisation;

## Technology Stack

Here is the list of frameworks, that were used in this project:

* **Architecture** - [Decompose](https://arkivanov.github.io/Decompose), [MVIKotlin](https://arkivanov.github.io/MVIKotlin)
* **UI** - [Compose Multiplatform](https://www.jetbrains.com/compose-multiplatform)
* **Concurrency** - [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
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
| |- 2.2 config
| |- 2.3 logger
| |- 2.4 resource
| |- 2.5 core
| | |- 2.5.1 client
| | |- 2.5.2 db
| | |- ...
| |- 2.6 design
| | |- 2.6.1 theme
| | |- 2.6.2 system
| |- 2.7 template
| | |- 2.7.1 source
| | |- 2.7.2 component
| | |- ...
| |- 2.8 feature
| | |- 2.8.1 artist
| | | |- 2.8.1.1 model
| | | | |- 2.8.1.1.1 artifact
| | | | |- 2.8.1.1.2 core
| | | |- 2.8.1.2 source
| | | |- 2.8.1.3 domain
| | | |- 2.8.1.4 design
| | | |- 2.8.1.5 component
| | | | |- 2.8.1.5.1 list
| | | | |- 2.8.1.5.2 details
| | | | |- ...
| | |- 2.8.2 album
| | |- ...
| |- 2.9 navigation
| |- 2.10 di
| |- 2.11 app
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

Custom convention plugins for project's build.gradle.kts files optimisation.
Provided plugins are used for initializing multiplatform libraries, dependencies bundles and so on.

### 2. shared

Shared project code.

### 2.1 shared.foundation

project unspecific code.
Manipulates with primitives and external libraries.
Provides useful extensions and abstractions for effective development.
Can be extracted to libraries.

***Contains:***
Primitives (Int, String, List,...) extensions;
Serializable extensions for unified json serialization;
KMP dispatcher for multiplatform coroutines;
Basic abstractions (mappers, identified entities, timestamps, etc.);
Custom compose modifiers;
Decompose components base implementations;
etc.

### 2.2 shared.logger
Shared logger for multiplatform debug.

### 2.3 shared.config
Project share build configuration.
Depends on the selected build variant (for Android) or build scheme (for iOS).

### 2.4 shared.resource
Project shared resources: strings, images, etc.

### 2.5 shared.core

Project specific foundation modules. 
Provide logic and models that can be used in any feature module.
All the core modules are feature unspecific (do not depend on any feature at all or any in particular).

***Contains:***
Logger;
Http service;
Local database;
Preference storage;
Toast manager;
etc.

### 2.6 shared.design

Projects ui theme (colors, shapes, etc.) and basic ui elements(button, radio group, etc.).
Feature unspecific views.

### 2.7 shared.template

Base abstractions for creating typical feature modules.

***Contains:***
Base component implementation;
Abstraction over core data sources for feature sources.

### 2.8 shared.feature

Apps sources, models, logic and design divided by features.

### 2.8.1 shared.feature.artist 

Feature specific code.
Used Artist feature as an example.

### 2.8.1.1 shared.feature.artist.model

Domain feature models that are unspecific to any particular component.

### 2.8.1.1.1 shared.feature.artist.model.artifact

Contains models that can be implemented in other features model modules.
Used to prevent cycle dependencies.

***Contains:***
Simplified data classes that are contained in other features models as an entry points;
Interfaces that declares specific behavior;
Mappers for mapping data layer entities to the domain models.

### 2.8.1.1.2 shared.feature.artist.model.core

Feature specific models.
Mostly are not supposed to be imported in other features model modules.

***Contains:***
Data classes;
Request classes;
Enum dictionaries;
Mappers for mapping data layer entities to the domain models.

### 2.8.1.2 shared.feature.artist.source

Feature specific sources of data.

***Contains:***
Local data sources;
Remote data sources;
Paging data sources;
Paging data sources;
Storages;
etc.

### 2.8.1.3 shared.feature.artist.domain

Feature specific domain logic classes that accumulate logic for concise calls from components.

***Contains:***
Use cases;
Managers;
Validators;
Value holders;
etc.

### 2.8.1.4 shared.feature.artist.design

Feature ui elements.

***Contains:***
UI models;
Compose functions;
Mappers to map domain models to ui.

### 2.8.1.5 shared.feature.artist.component

Feature components (i.e. screens, bottom sheets, dialogs).

### 2.8.1.5.1 shared.feature.artist.component.list

Component, its logic and ui.

***Contains:***
UI and domain models of the component entities;
Component store entities (executor, ui state mapper, etc.).

### 2.9 shared.navigation

Global app navigation.
Can implement feature model modules.

***Contains:***
Navigation manager;
Configs with navigation arguments;

### 2.10 shared.di

Provides app's dependency injection module.
Combines all other di modules (from impl modules).

### 2.11 shared.app

Entry point for platforms to shared app code.
Implementation submodule is used for ios app ui view controller generation.

***Contains:***
Root compose function;
Root component implementation;
App di module;

### 3 android

Android specific code.

### 3.1 android.app

Android app implementation.

### 3.2 android.baseline

Android app baseline profile generator.

### 4 ios

IOS XCode project.

## Setup

In order to build a prod version of the project **CLIENT_ID** and **CLIENT_SECRET** of the API should be added to your `local.properties`.
Check [Spotify Web API Getting Started](https://developer.spotify.com/documentation/web-api/tutorials/getting-started#request-an-access-token) to learn how get them.

//TODO: Add alternative instructions for mock build
