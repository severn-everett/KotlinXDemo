plugins {
    kotlin("plugin.serialization") version "1.8.0"
}

group = "com.severneverett"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val serializationVersion: String by project
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
}

kotlin {
    js(IR) {
        binaries.executable()
        nodejs { }
    }
}
