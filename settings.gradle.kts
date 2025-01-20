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

// =====================================================================================================================
// Foundation

include(":shared:foundation:primitive")
include(":shared:foundation:serialization")
include(":shared:foundation:model")

// =====================================================================================================================
// Core

include(":shared:core:client:api")
include(":shared:core:client:impl")

include(":shared:core:dispatcher")

// =====================================================================================================================
// Common

include(":shared:common:component")
include(":shared:common:source")

// =====================================================================================================================
// Feature

// Artist
include(":shared:feature:artist:model:api")
include(":shared:feature:artist:model:impl")

include(":shared:feature:artist:source:api")
include(":shared:feature:artist:source:impl")

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

include(":shared:app")

// =====================================================================================================================
// Android
include(":android:app")
//FIXME: Add baseline profile