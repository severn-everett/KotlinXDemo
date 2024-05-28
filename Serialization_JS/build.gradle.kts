plugins {
    kotlin("plugin.serialization") version "1.9.24"
}

group = "com.severneverett"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    js(IR) {
        binaries.executable()
        nodejs { }
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                val serializationVersion: String by project
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
            }
        }
    }
}
