dependencies {
    api(project(":kwidgets-native"))
}

tasks {
    processResources {
        include("**/*.png")
    }
}