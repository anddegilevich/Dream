plugins {
    alias(libs.plugins.project.feature.data.mapper.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.player.data.mapper.api)
            implementation(projects.shared.feature.track.data.mapper.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.player.data.mapper.test)
            implementation(projects.shared.feature.player.domain.model.core.test)
            implementation(projects.shared.feature.track.data.mapper.test)
            implementation(projects.shared.feature.track.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.player.data.mapper.impl"
    }
}
