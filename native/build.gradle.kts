
tasks {
    clean {
        delete("$projectDir/src/main/include")
    }

    compileJava {
        val headers = File("$projectDir/src/main/include")
        if (!headers.exists()) headers.mkdirs()

        options.compilerArgs.addAll(listOf(
            "-h", headers.absolutePath
        ))
        options.isFork = true
    }
}