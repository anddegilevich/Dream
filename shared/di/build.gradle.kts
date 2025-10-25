plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            // Logger
            implementation(projects.shared.logger)

            // Resource
            implementation(projects.shared.resource.impl)

            // Core
            implementation(projects.shared.core.datetime.impl)
            implementation(projects.shared.core.storage.impl)
            implementation(projects.shared.core.client.impl)
            implementation(projects.shared.core.service.impl)
            implementation(projects.shared.core.db.impl)
            implementation(projects.shared.core.toast.impl)

            // Navigation
            implementation(projects.shared.navigation.impl)

            // Feature
            implementation(projects.shared.feature.image.source.impl)

            implementation(projects.shared.feature.artist.source.impl)
            implementation(projects.shared.feature.artist.domain.impl)
            implementation(projects.shared.feature.artist.design.impl)

            implementation(projects.shared.feature.album.source.impl)
            implementation(projects.shared.feature.album.domain.impl)
            implementation(projects.shared.feature.album.design.impl)

            implementation(projects.shared.feature.track.source.impl)
            implementation(projects.shared.feature.track.domain.impl)
            implementation(projects.shared.feature.track.design.impl)

            implementation(projects.shared.feature.search.source.impl)
            implementation(projects.shared.feature.search.domain.impl)
            implementation(projects.shared.feature.search.design.impl)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.di"
}