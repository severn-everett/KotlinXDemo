buildscript {
    repositories {
        mavenCentral()
    }
}

apply(plugin = "kotlinx-atomicfu")

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
                dependencies {
                    val coroutinesVersion: String by project
                    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                }
            }
        }
    }
}
