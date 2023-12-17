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
//    mappings("parchment", "${libs.versions.parchment.build.get()}-${libs.versions.minecraft.get()}")
    mappings("official", libs.versions.minecraft.get())

    copyIdeResources.set(true)
}

tasks {
    assemble {
        dependsOn("copyReobfShadowJar")
    }

    shadowJar {
        dependencies {
            include { it.moduleGroup == project.group }
        }

        archiveClassifier.set("dev")
    }

    register<Copy>("copyReobfShadowJar") {
        dependsOn("reobfShadowJar", "reobfJar")

        val buildDir = project.layout.buildDirectory.get()
        val name = "${project.name}-${project.version}.jar"

        destinationDir = file("$buildDir/libs")

        from("$buildDir/reobfShadowJar/output.jar")
        rename { _ -> name }

        outputs.file("$buildDir/libs/$name")
    }
}

extensions.getByName<NamedDomainObjectContainer<RenameJarInPlace>>("reobf").create("shadowJar") {
    input.set(tasks.shadowJar.get().archiveFile)
}