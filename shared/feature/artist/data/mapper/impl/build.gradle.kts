plugins {
    alias(libs.plugins.project.feature.data.mapper.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.data.mapper.api)
            implementation(projects.shared.feature.image.data.mapper.api)
            implementation(projects.shared.feature.album.data.mapper.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.image.data.mapper.test)
            implementation(projects.shared.feature.image.domain.model.artifact.test)
            implementation(projects.shared.feature.album.data.mapper.test)
            implementation(projects.shared.feature.album.domain.model.artifact.test)
            implementation(projects.shared.feature.artist.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.data.mapper.impl"
    }
}
