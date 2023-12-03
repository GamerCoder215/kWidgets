import net.minecraftforge.gradle.userdev.tasks.RenameJarInPlace

plugins {
    alias(libs.plugins.forge)
    alias(libs.plugins.parchment)
}

dependencies {
    api(project(":kwidgets-core"))

    minecraft(libs.forge)
    implementation("thedarkcolour:kotlinforforge:3.12.0")
}

minecraft {
    mappings("parchment", "${libs.versions.parchment.build.get()}-${libs.versions.minecraft.get()}")

    copyIdeResources.set(true)
}

tasks {
    assemble {
        dependsOn("copyReobfShadowJar")
    }

    shadowJar {
        dependencies {
            exclude {
                it.moduleGroup != project.group
            }
        }
    }

    register<Copy>("copyReobfShadowJar") {
        dependsOn("reobfShadowJar", "reobfJar")

        destinationDir = file("$buildDir/libs")

        from("$buildDir/reobfShadowJar/output.jar")
        rename { _ -> "${project.name}-${project.version}.jar"}
    }
}

extensions.getByName<NamedDomainObjectContainer<RenameJarInPlace>>("reobf").create("shadowJar") {
    input.set(tasks.shadowJar.get().archiveFile)
}