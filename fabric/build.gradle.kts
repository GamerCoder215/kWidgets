@file:Suppress("UnstableApiUsage")

import net.fabricmc.loom.api.LoomGradleExtensionAPI
import net.fabricmc.loom.task.RemapJarTask

plugins {
    alias(libs.plugins.fabric.loom)
}

dependencies {
    api(project(":kwidgets-core"))

    minecraft(libs.minecraft)
    mappings(loom.layered {
        parchment("org.parchmentmc.data:parchment-${libs.versions.minecraft.get()}:${libs.versions.parchment.build.get()}")
        officialMojangMappings()
    })
    modImplementation(libs.fabric.loader)
    modImplementation(libs.fabric.api)
}

tasks {
    assemble {
        dependsOn(remapJar)
    }

    shadowJar {
        dependencies {
            exclude {
                it.moduleGroup != project.group
            }
        }
    }

    remapJar {
        dependsOn(shadowJar)

        inputFile.set(shadowJar.get().archiveFile)
        addNestedDependencies.set(true)
        archiveClassifier.set("remapped")
    }
}

artifacts {
    add("default", tasks.getByName<RemapJarTask>("remapJar"))
}