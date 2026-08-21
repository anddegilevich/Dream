plugins {
    alias(libs.plugins.project.feature.data.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.data.api)
            implementation(projects.shared.feature.artist.data.mapper.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.artist.data.mapper.test)
            implementation(projects.shared.feature.artist.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.data.impl"
    }
}