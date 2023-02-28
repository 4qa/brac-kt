pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/dokka/dev")
    }
}

rootProject.name = "brac-kt"
include("brac-kt-api", "brac-kt-ibmq-provider", "example-jvm-java", "example-jvm-kotlin")
