rootProject.name = "kWidgets"

// Modules

listOf("core", "fabric", "forge", "quilt").forEach {
    include(":kwidgets-$it")
    project(":kwidgets-$it").projectDir = rootDir.resolve(it)
}

// Plugins

pluginManagement {
    repositories {
        gradlePluginPortal()

        maven("https://maven.fabricmc.net/")
        maven("https://maven.quiltmc.org/repository/release")
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