subprojects {
    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        maven("https://us-central1-maven.pkg.dev/varabyte-repos/public")
    }
}

repositories {
    mavenCentral()
}

plugins {
    alias(libs.plugins.spotless)
}

spotless {
    kotlin {
        target("site/src/**/*.kt")
        ktfmt().googleStyle()
    }
}
