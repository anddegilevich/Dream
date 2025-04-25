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
include(":shared:foundation:coroutine")
include(":shared:foundation:serialization")
include(":shared:foundation:abstraction")
include(":shared:foundation:dispatcher")
include(":shared:foundation:compose")
include(":shared:foundation:filepicker")

include(":shared:foundation:decompose:navigation")
include(":shared:foundation:decompose:compose")
include(":shared:foundation:decompose:component")

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

include(":shared:template:source")
include(":shared:template:component")

// =====================================================================================================================
// Feature

// Image
include(":shared:feature:image:model:artifact")

// Artist
include(":shared:feature:artist:model:artifact")
include(":shared:feature:artist:model:core")

include(":shared:feature:artist:core:api")
include(":shared:feature:artist:core:impl")

include(":shared:feature:artist:design:api")
include(":shared:feature:artist:design:impl")

include(":shared:feature:artist:component:details:api")
include(":shared:feature:artist:component:details:impl")

include(":shared:feature:artist:component:list:api")
include(":shared:feature:artist:component:list:impl")

// Album
include(":shared:feature:album:model:artifact")

// Track
include(":shared:feature:track:model:artifact")
include(":shared:feature:track:model:core")

// User
include(":shared:feature:user:component:profile:api")
include(":shared:feature:user:component:profile:impl")

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
// Android

include(":android:app")
include(":android:baseline")
