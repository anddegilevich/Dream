plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.di)
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
            implementation(projects.shared.core.crypto.impl)
            implementation(projects.shared.core.client.impl)
            implementation(projects.shared.core.service.impl)
            implementation(projects.shared.core.db.impl)
            implementation(projects.shared.core.toast.impl)

            // Navigation
            implementation(projects.shared.navigation.impl)

            // Feature
            implementation(projects.shared.feature.image.data.mapper.impl)

            implementation(projects.shared.feature.artist.data.impl)
            implementation(projects.shared.feature.artist.data.mapper.impl)
            implementation(projects.shared.feature.artist.domain.impl)
            implementation(projects.shared.feature.artist.ui.impl)
            implementation(projects.shared.feature.artist.component.details.impl)

            implementation(projects.shared.feature.album.data.impl)
            implementation(projects.shared.feature.album.data.mapper.impl)
            implementation(projects.shared.feature.album.domain.impl)
            implementation(projects.shared.feature.album.ui.impl)
            implementation(projects.shared.feature.album.component.details.impl)
            implementation(projects.shared.feature.album.component.releases.impl)

            implementation(projects.shared.feature.track.data.impl)
            implementation(projects.shared.feature.track.data.mapper.impl)
            implementation(projects.shared.feature.track.domain.impl)
            implementation(projects.shared.feature.track.ui.impl)
            implementation(projects.shared.feature.track.component.details.impl)

            implementation(projects.shared.feature.search.data.impl)
            implementation(projects.shared.feature.search.data.mapper.impl)
            implementation(projects.shared.feature.search.domain.impl)
            implementation(projects.shared.feature.search.ui.impl)
            implementation(projects.shared.feature.search.component.search.impl)

            // Common
            implementation(projects.shared.feature.common.component.splash.impl)
            implementation(projects.shared.feature.common.component.home.impl)
            implementation(projects.shared.feature.common.component.dashboard.impl)
            implementation(projects.shared.feature.common.component.navbar.impl)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.di"
    }
}