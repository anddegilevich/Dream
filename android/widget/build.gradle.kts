plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.android)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "and.degilevich.dream.widget"
}

dependencies {
    implementation(libs.glance.appwidget)
}

