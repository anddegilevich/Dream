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
include(":shared:foundation:compose")

include(":shared:foundation:decompose:navigator")
include(":shared:foundation:decompose:lifecycle")
include(":shared:foundation:decompose:compose")
include(":shared:foundation:decompose:component")

// =====================================================================================================================
// Core

include(":shared:core:logger")

include(":shared:core:config")

include(":shared:core:resource:api")
include(":shared:core:resource:impl")

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

// =====================================================================================================================
// Compose

include(":shared:compose:theme")
include(":shared:compose:design")

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

include(":shared:feature:artist:compose")

include(":shared:feature:artist:component:details:api")
include(":shared:feature:artist:component:details:impl")

include(":shared:feature:artist:component:list:api")
include(":shared:feature:artist:component:list:impl")

// Album
include(":shared:feature:album:model:core")

// Track
include(":shared:feature:track:model:artifact")
include(":shared:feature:track:model:core")

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
//include(":android:baseline")