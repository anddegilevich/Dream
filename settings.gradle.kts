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
include(":shared:foundation:model")
include(":shared:foundation:dispatcher")
include(":shared:foundation:logger")

include(":shared:foundation:decompose:navigator")
include(":shared:foundation:decompose:lifecycle")
include(":shared:foundation:decompose:compose")
include(":shared:foundation:decompose:component")

// =====================================================================================================================
// Core

include(":shared:core:client:api")
include(":shared:core:client:impl")

include(":shared:core:storage:api")
include(":shared:core:storage:impl")

// =====================================================================================================================
// Common

include(":shared:common:source")

// =====================================================================================================================
// Compose
include(":shared:compose:foundation")

// =====================================================================================================================
// Feature

// Artist
include(":shared:feature:artist:model:artifact")
include(":shared:feature:artist:model:core")

include(":shared:feature:artist:core:api")
include(":shared:feature:artist:core:impl")

include(":shared:feature:artist:compose")

include(":shared:feature:artist:component:details:api")
include(":shared:feature:artist:component:details:impl")

include(":shared:feature:artist:component:list:api")
include(":shared:feature:artist:component:list:impl")

// =====================================================================================================================
// Navigation

include(":shared:navigation:api")
include(":shared:navigation:impl")

// =====================================================================================================================
// App

include(":shared:app:api")
include(":shared:app:impl")

// =====================================================================================================================
// Android
include(":android:app")
//FIXME: Add baseline profile