plugins {
    kotlin("plugin.serialization") version "1.7.22"
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
