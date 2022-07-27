group = "com.severneverett"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
    implementation(npm("@js-joda/timezone", "2.12.0"))
}

kotlin {
    js(IR) {
        binaries.executable()
        nodejs {

        }
    }
}
