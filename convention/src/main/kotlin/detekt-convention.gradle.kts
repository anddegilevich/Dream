import and.degilevich.dream.convention.common.javaVersion
import dev.detekt.gradle.Detekt
import dev.detekt.gradle.DetektCreateBaselineTask

plugins {
    id("dev.detekt")
}

detekt {
    config.setFrom(rootProject.file("detekt/detekt.yml"))
    buildUponDefaultConfig = true
    source.from("src")
}

tasks.named { it == "check" }.configureEach {
    dependsOn(tasks.named("detekt"))
}

tasks.withType<Detekt>().configureEach {
    exclude {
        it.file.absolutePath.contains("build/")
    }
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = javaVersion().toString()
}
tasks.withType<DetektCreateBaselineTask>().configureEach {
    jvmTarget = javaVersion().toString()
}

dependencies {
    // libs.versions.detekt - gradle/libs.versions.toml
    detektPlugins("dev.detekt:detekt-rules-ktlint-wrapper:2.0.0-alpha.6")
    // libs.versions.detekt.compose - gradle/libs.versions.toml
    detektPlugins("io.nlopez.compose.rules:detekt:0.6.8")
}
