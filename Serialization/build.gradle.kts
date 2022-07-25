plugins {
    kotlin("plugin.serialization") version "1.7.10"
}

group = "com.severneverett"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
}
