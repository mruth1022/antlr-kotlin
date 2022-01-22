plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

//TODO: Remove this code after migrating to kotlin multiplatform plugin version 1.6.20+
rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().nodeVersion = "16.0.0"
}

repositories {
    mavenCentral()
    mavenLocal()
}

apply(plugin = "maven-publish")

kotlin {
    jvm()
    js(BOTH) {
        browser {
        }
        nodejs {
        }
    }

    ios("ios") {
        binaries {
            staticLib()
        }
    }
    iosSimulatorArm64("iosSimulator") {
        binaries {
            staticLib()
        }
    }
    linuxX64("linux") {
        binaries {
            staticLib()
        }
    }
    macosX64("mac") {
        binaries {
            staticLib()
        }
    }
    mingwX64("windows") {
        binaries {
            staticLib()
        }
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(kotlin("reflect"))
                implementation("com.benasher44:uuid:0.4.0")
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
        val nativeMain by creating {
        }
        val iosMain by getting {
            dependsOn(nativeMain)
        }
        val iosSimulatorMain by getting {
            dependsOn(iosMain)
        }
        val linuxMain by getting {
            dependsOn(nativeMain)
        }
        val macMain by getting {
            dependsOn(nativeMain)
        }
        val windowsMain by getting {
            dependsOn(nativeMain)
        }
    }
}
