plugins {
    alias(libs.plugins.project.feature.ui.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.player.ui.api)
            implementation(projects.shared.core.datetime.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.player.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.player.ui.impl"
    }
}
