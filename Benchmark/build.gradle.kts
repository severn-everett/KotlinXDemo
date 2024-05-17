plugins {
    kotlin("plugin.allopen") version "1.9.24"
    id("org.jetbrains.kotlinx.benchmark") version "0.4.10"
}

apply(plugin = "org.jetbrains.kotlinx.benchmark")

group = "com.severneverett"
version = "1.0-SNAPSHOT"

allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime-jvm:0.4.10")
}

benchmark {
    targets {
        register("test")
    }
}
