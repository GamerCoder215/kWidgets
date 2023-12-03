@file:Suppress("UnstableApiUsage")

plugins {
    alias(libs.plugins.quilt.loom)
}

dependencies {
    api(project(":kwidgets-core"))

    minecraft(libs.minecraft)
    mappings(loom.layered {
        parchment("org.parchmentmc.data:parchment-${libs.versions.minecraft.get()}:${libs.versions.parchment.build.get()}")
        officialMojangMappings()
    })
    modImplementation(libs.quilt.loader)
    modImplementation(libs.quilted.fabric.api)
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
        mustRunAfter(":kwidgets-fabric:remapJar") // Prevent them from accesssing the same mappings at the same time

        inputFile.set(shadowJar.get().archiveFile)
        addNestedDependencies.set(true)
        archiveClassifier.set("remapped")
    }
}
