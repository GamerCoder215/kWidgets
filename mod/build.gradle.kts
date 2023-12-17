tasks {
    jar {
        val depends = listOf(
            ":kwidgets-fabric:remapJar",
            ":kwidgets-forge:copyReobfShadowJar"
        )

        depends.forEach { task ->
            dependsOn(task)

            val split = task.substring(1).split(":")
            from(zipTree({project(":${split[0]}").tasks.getByName(split[1]).outputs.files.filter { it.isFile }.singleFile}))
        }

        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
}