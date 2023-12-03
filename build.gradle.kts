plugins {
    kotlin("jvm") version "1.9.21" apply false
    id("com.github.johnrengelman.shadow") version "8.1.1" apply false

    java
    `java-library`
    jacoco
    idea
}

allprojects {
    apply(plugin = "maven-publish")
    apply(plugin = "idea")
    apply<JavaPlugin>()
    apply<JavaLibraryPlugin>()

    group = "me.gamercoder215.kwidgets"
    version = "0.1.0"
    description = "Forge, Fabric & Quilt Client Mod featuring 100+ customizable widgets available on your screen, written in Kotlin."
    project.ext.apply {
        this["id"] = "kwidgets"
        this["name"] = "kWidgets"
        this["github"] = "https://github.com/GamerCoder215/kWidgets"
        this["discord"] = "https://discord.gg/WVFNWEvuqX"
        this["author"] = "GamerCoder215"
        this["license"] = "LGPL-3.0"
    }

    repositories {
        mavenCentral()
        mavenLocal()

        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://oss.sonatype.org/content/repositories/central")

        maven("https://repo.codemc.org/repository/nms/")
        maven("https://maven.fabricmc.net/")
        maven("https://maven.quiltmc.org/repository/release")
        maven("https://maven.minecraftforge.net/")
        maven("https://maven.parchmentmc.org")
        maven("https://thedarkcolour.github.io/KotlinForForge/")
    }

}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "com.github.johnrengelman.shadow")
    apply<JacocoPlugin>()

    dependencies {
        compileOnly(kotlin("stdlib"))
    }

    tasks {
        processResources {
            filesNotMatching("**/*.png") {
                expand(project.properties)
            }
        }
    }
}