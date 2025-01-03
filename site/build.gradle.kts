import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

group = "xyz.malefic"
version = "1.0.0"

kobweb {
    app {
        index {
            description.set("Malefic Xyz - Om Gupta's portfolio")
            head.add {
                link(rel = "preconnect", href = "https://fonts.googleapis.com")
                link(
                    rel = "preconnect",
                    href = "https://fonts.gstatic.com",
                ) { attributes["crossorigin"] = "" }
                link(
                    href =
                        "https://fonts.googleapis.com/css2?family=DM+Sans:ital,opsz,wght@0,9..40,100;0,9..40,200;0,9." +
                            ".40,300;0,9..40,400;0,9..40,500;0,9..40,600;0,9..40,700;0,9..40,800;0,9..40,900;0,9..40," +
                            "1000;1,9..40,100;1,9..40,200;1,9..40,300;1,9..40,400;1,9..40,500;1,9..40,600;1,9..40,700" +
                            ";1,9..40,800;1,9..40,900;1,9..40,1000&family=Space+Grotesk:wght@300;400;500;600;700&fami" +
                            "ly=Tauri&display=swap",
                    rel = "stylesheet",
                )
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("kotfolio")
    js {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions.target = "es2015"
    }

    sourceSets {
        commonMain.dependencies {
            dependencies {
                implementation(libs.compose.runtime)
            }
        }

        jsMain.dependencies {
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            // implementation(libs.silk.icons.fa)
            implementation(libs.kobwebx.markdown)
        }
    }
}
