import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_19
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.20.2")
    }
}

plugins {
    kotlin("jvm") version "1.8.20"
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
            compilerOptions {
                jvmTarget.set(JVM_19)
            }
        }
    }
}