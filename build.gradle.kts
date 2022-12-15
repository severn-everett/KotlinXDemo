import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.18.5")
    }
}

plugins {
    kotlin("jvm") version "1.7.22"
}

group = "com.severneverett"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

subprojects {
    if (this.name.endsWith("_JS")) {
        apply(plugin = "org.jetbrains.kotlin.js")
    } else {
        apply(plugin = "org.jetbrains.kotlin.jvm")
        tasks.withType<KotlinCompile> {
            kotlinOptions.jvmTarget = "18"
        }
    }
}