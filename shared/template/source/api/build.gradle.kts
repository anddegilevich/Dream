plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    androidLibrary {
        namespace = "and.degilevich.dream.shared.template.source.api"
    }
}