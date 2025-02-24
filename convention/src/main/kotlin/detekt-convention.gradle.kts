plugins {
    id("io.gitlab.arturbosch.detekt")
}

detekt {
    config.setFrom(rootProject.file("detekt/detekt.yml"))
    buildUponDefaultConfig = true
    source.from("src")
}

tasks.matching { it.name == "check" }.configureEach {
    dependsOn(detekt)
}

dependencies {
    // libs.versions.detekt - gradle/libs.versions.toml:12
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.8")
    // libs.versions.detekt.compose - gradle/libs.versions.toml
    detektPlugins("com.twitter.compose.rules:detekt:0.0.26")
}