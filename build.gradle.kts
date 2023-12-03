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
    val author = "GamerCoder"

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
    }

}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "com.github.johnrengelman.shadow")
    apply<JacocoPlugin>()
}