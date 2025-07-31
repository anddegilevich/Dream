@file:Suppress("UnstableApiUsage") // Fixes dependencyResolutionManagement.repositories warning

rootProject.name = "Dream"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("convention")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

// Shared

// =====================================================================================================================
// Foundation

include(":shared:foundation:primitive")
include(":shared:foundation:serialization")
include(":shared:foundation:abstraction")
include(":shared:foundation:decompose")
include(":shared:foundation:compose")
include(":shared:foundation:filepicker")

// =====================================================================================================================
// Config
include(":shared:config")

// =====================================================================================================================
// Logger
include(":shared:logger")

// =====================================================================================================================
// Resource
include(":shared:resource:api")
include(":shared:resource:impl")

// =====================================================================================================================
// Core

include(":shared:core:client:api")
include(":shared:core:client:impl")

include(":shared:core:service:api")
include(":shared:core:service:impl")

include(":shared:core:storage:api")
include(":shared:core:storage:impl")

include(":shared:core:db:api")
include(":shared:core:db:impl")

include(":shared:core:toast:api")
include(":shared:core:toast:impl")

include(":shared:core:filepicker:api")
include(":shared:core:filepicker:impl")

// =====================================================================================================================
// Design

include(":shared:design:theme")
include(":shared:design:system")

// =====================================================================================================================
// Template

include(":shared:template:source:api")
include(":shared:template:source:impl")

include(":shared:template:domain:api")
include(":shared:template:domain:impl")

include(":shared:template:component:api")
include(":shared:template:component:impl")

// =====================================================================================================================
// Feature

// Common
include(":shared:feature:common:component:splash:api")
include(":shared:feature:common:component:splash:impl")

include(":shared:feature:common:component:dashboard:api")
include(":shared:feature:common:component:dashboard:impl")

include(":shared:feature:common:component:navbar:api")
include(":shared:feature:common:component:navbar:impl")

// Image
include(":shared:feature:image:model:artifact:api")
include(":shared:feature:image:model:artifact:impl")

// Artist
include(":shared:feature:artist:model:artifact:api")
include(":shared:feature:artist:model:artifact:impl")

include(":shared:feature:artist:model:core:api")
include(":shared:feature:artist:model:core:impl")

include(":shared:feature:artist:source:api")
include(":shared:feature:artist:source:impl")

include(":shared:feature:artist:domain:api")
include(":shared:feature:artist:domain:impl")

include(":shared:feature:artist:design:api")
include(":shared:feature:artist:design:impl")

include(":shared:feature:artist:component:details:api")
include(":shared:feature:artist:component:details:impl")

// Album
include(":shared:feature:album:model:artifact:api")
include(":shared:feature:album:model:artifact:impl")

include(":shared:feature:album:model:core:api")
include(":shared:feature:album:model:core:impl")

include(":shared:feature:album:source:api")
include(":shared:feature:album:source:impl")

include(":shared:feature:album:domain:api")
include(":shared:feature:album:domain:impl")

include(":shared:feature:album:design:api")
include(":shared:feature:album:design:impl")

include(":shared:feature:album:component:releases:api")
include(":shared:feature:album:component:releases:impl")

include(":shared:feature:album:component:details:api")
include(":shared:feature:album:component:details:impl")

// Track
include(":shared:feature:track:model:artifact:api")
include(":shared:feature:track:model:artifact:impl")

include(":shared:feature:track:model:core:api")
include(":shared:feature:track:model:core:impl")

include(":shared:feature:track:source:api")
include(":shared:feature:track:source:impl")

include(":shared:feature:track:domain:api")
include(":shared:feature:track:domain:impl")

include(":shared:feature:track:design:api")
include(":shared:feature:track:design:impl")

include(":shared:feature:track:component:details:api")
include(":shared:feature:track:component:details:impl")

// User
include(":shared:feature:user:component:profile:api")
include(":shared:feature:user:component:profile:impl")

// Search
include(":shared:feature:search:model:core:api")
include(":shared:feature:search:model:core:impl")

include(":shared:feature:search:source:api")
include(":shared:feature:search:source:impl")

include(":shared:feature:search:domain:api")
include(":shared:feature:search:domain:impl")

include(":shared:feature:search:design:api")
include(":shared:feature:search:design:impl")

include(":shared:feature:search:component:search:api")
include(":shared:feature:search:component:search:impl")

// =====================================================================================================================
// Navigation

include(":shared:navigation:api")
include(":shared:navigation:impl")

// =====================================================================================================================
// Di

include(":shared:di")

// =====================================================================================================================
// App

include(":shared:app:api")
include(":shared:app:impl")

// =====================================================================================================================
// Widget

include(":shared:widget:api")
include(":shared:widget:impl")

// =====================================================================================================================
// Android

include(":android:app")
include(":android:baseline")
include(":android:backend")