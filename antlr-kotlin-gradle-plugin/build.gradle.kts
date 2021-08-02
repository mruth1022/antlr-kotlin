plugins {
    `java-library`
    `maven-publish`
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "0.14.0"
}

dependencies {
    implementation("org.antlr:antlr4:${Versions.antlr}")
    implementation(gradleApi())
    implementation(project(":antlr-kotlin-target"))
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
        }
    }
}

pluginBundle {
    website = "https://github.com/Strumenta/antlr-kotlin"
    vcsUrl = "https://github.com/Strumenta/antlr-kotlin.git"
    tags = listOf("antlr", "kotlin")
}

gradlePlugin {
    plugins {
        create("antlrKotlinPlugin") {
            id = "com.strumenta.antlr-kotlin"
            displayName = "ANTLR Kotlin"
            description = "ANTLR Kotlin gradle plugin"
            implementationClass = "com.strumenta.antlrkotlin.gradleplugin.AntlrKotlinTask"
        }
    }
}