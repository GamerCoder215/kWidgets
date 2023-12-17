@file:Suppress("UnstableApiUsage")

import net.fabricmc.loom.api.LoomGradleExtensionAPI
import net.fabricmc.loom.task.RemapJarTask
import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion

plugins {
    alias(libs.plugins.fabric.loom)
}

dependencies {
    api(project(":kwidgets-core"))

    minecraft(libs.minecraft)
    mappings(loom.layered {
        officialMojangMappings()
//        parchment("org.parchmentmc.data:parchment-${libs.versions.minecraft.get()}:${libs.versions.parchment.build.get()}@zip")
    })
    modImplementation(libs.fabric.loader)
    modImplementation(libs.fabric.api)
    modImplementation("net.fabricmc:fabric-language-kotlin:1.10.16+kotlin.${getKotlinPluginVersion()}")
}

tasks {
    assemble {
        dependsOn(remapJar)
    }

    shadowJar {
        dependencies {
            include { it.moduleGroup == project.group }
        }

        exclude("mappings/**")

        archiveClassifier.set("dev")
    }

    remapJar {
        dependsOn(shadowJar)

        inputFile.set(shadowJar.get().archiveFile)
        addNestedDependencies.set(true)
        archiveFileName.set("${project.name}-${project.version}.jar")
    }
}

artifacts {
    add("default", tasks.getByName<RemapJarTask>("remapJar"))
}