plugins {
    kotlin("multiplatform") version "1.7.21" apply false
    kotlin("jvm") version "1.7.21" apply false
    kotlin("js") version "1.7.21" apply false
    kotlin("plugin.serialization") version "1.7.21" apply false
    id("org.jetbrains.dokka") version "1.7.20"
    id("io.gitlab.arturbosch.detekt") version "1.22.0" apply false
    id("maven-publish")
}

repositories {
    mavenCentral()
}

subprojects {
    group = "net.javaman.brac-kt"
    version = "0.1.7"

    ext {
        set("jvmTarget", "11")
        set("datetimeVersion", "0.3.1")
        set("ktorVersion", "1.6.6")
        set("jupiterVersion", "5.7.0")
        set("coroutinesVersion", "1.5.2")
        set("coroutinesMtVersion", "1.5.2-native-mt")
    }
}

tasks.dokkaHtmlMultiModule.configure {
    outputDirectory.set(rootDir.resolve("docs"))
}
