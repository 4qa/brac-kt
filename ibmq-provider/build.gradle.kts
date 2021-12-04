plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("org.jetbrains.dokka")
}

repositories {
    mavenCentral()
}

val jvmTarget: String by ext
val datetimeVersion: String by ext
val coroutinesVersion: String by ext
val ktorVersion: String by ext
val jupiterVersion: String by ext

kotlin {
    jvm {
        val main by compilations.getting {
            kotlinOptions {
                jvmTarget = jvmTarget
            }
        }
        val test by compilations.getting {
            kotlinOptions {
                jvmTarget = jvmTarget
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":api"))
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-cio:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                api("org.jetbrains.kotlinx:kotlinx-datetime:$datetimeVersion")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation("org.junit.jupiter:junit-jupiter:$jupiterVersion")
            }
        }
        all {
            languageSettings.optIn("kotlin.RequiresOptIn")
        }
    }
}

detekt {
    this.source = objects.fileCollection().from(
        "src/commonMain/kotlin",
        "src/jvmMain/kotlin",
        "src/jvmTest/kotlin"
    )
}

tasks.withType<Test>().getByName("jvmTest") {
    useJUnitPlatform()
}
