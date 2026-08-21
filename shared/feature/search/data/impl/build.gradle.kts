plugins {
    alias(libs.plugins.project.feature.data.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.data.api)
            implementation(projects.shared.feature.search.data.mapper.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.search.data.mapper.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.data.impl"
    }
}