rootProject.name = "kWidgets"

// Modules

listOf("core", "fabric", "forge", "mod", "native").forEach {
    include(":kwidgets-$it")
    project(":kwidgets-$it").projectDir = rootDir.resolve(it)
}

// Plugins

pluginManagement {
    repositories {
        gradlePluginPortal()

        maven("https://maven.fabricmc.net/")
        maven("https://maven.minecraftforge.net/")
        maven("https://maven.parchmentmc.org")
    }
}

// Dependency Resolution Management

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("libs.versions.toml"))
        }
    }
}