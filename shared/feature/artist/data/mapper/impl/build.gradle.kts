plugins {
    alias(libs.plugins.project.template.data.mapper.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.data.mapper.api)
            implementation(projects.shared.feature.image.data.mapper.api)
            implementation(projects.shared.feature.album.data.mapper.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.data.mapper.impl"
    }
}
