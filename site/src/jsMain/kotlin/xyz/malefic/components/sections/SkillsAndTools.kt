package xyz.malefic.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import xyz.malefic.components.styles.ExperienceStyle
import xyz.malefic.components.widgets.AppearanceAwareImage
import xyz.malefic.components.widgets.GlassBox
import xyz.malefic.components.widgets.SectionTitle
import xyz.malefic.utils.Res

@Composable
fun SkillsAndTools() {
    Column(
        modifier = ExperienceStyle.toModifier().id("skills_and_tools"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionTitle("Skills & Tools.")

        SimpleGrid(
            modifier = Modifier.fillMaxWidth().margin(top = 2.cssRem),
            numColumns = numColumns(base = 1, sm = 2),
        ) {
            GlassBox(modifier = Modifier.margin(all = 2.cssRem)) {
                SimpleGrid(
                    modifier = Modifier.padding(all = 1.cssRem),
                    numColumns = numColumns(base = 2, sm = 2, md = 3, lg = 4),
                ) {
                    Res.Images.apply {
                        IconGlassBoxes(
                            KOTLIN_LOGO.src,
                            JETPACK_COMPOSE_LOGO.src,
                            KTOR_LOGO.src,
                            JAVA_LOGO.src,
                            PYTHON_LOGO.src,
                            ANDROID_LOGO.src,
                            APPLE_LOGO.withMod(invert = false),
                            ASCIIDOC_LOGO.src,
                            TRELLO_LOGO.src,
                            SLACK_LOGO.src,
                            PORTAINER_LOGO.src,
                            HOMEBREW_LOGO.src,
                        )
                    }
                }
            }

            GlassBox(modifier = Modifier.margin(all = 2.cssRem)) {
                SimpleGrid(
                    modifier = Modifier.padding(all = 1.cssRem),
                    numColumns = numColumns(base = 2, sm = 2, md = 3, lg = 4),
                ) {
                    Res.Images.apply {
                        IconGlassBoxes(
                            INTELLIJ_LOGO.src,
                            ARCH_LOGO.src,
                            GODOT_LOGO.src,
                            GRADLE_LOGO.src,
                            DOCKER_LOGO.src,
                            VSCODE_LOGO.src,
                            GIT_LOGO.src,
                            GITKRAKEN_LOGO.src,
                            POSTMAN_LOGO.src,
                            GITHUB_FILLED.withMod(),
                            GITHUB_ACTIONS_LOGO.src,
                            POSTGRE_LOGO.src,
                        )
                    }
                }
            }
        }
    }
}

/**
 * A composable function that creates a glass-like box containing an icon image.
 *
 * @param src The source URL of the image to be displayed inside the glass box.
 * @param modifier A [Modifier] to be applied to the image, allowing for customization of its size
 *   and appearance.
 */
@Composable
fun IconGlassBox(
    src: String,
    modifier: Modifier = Modifier,
) {
    GlassBox(modifier = Modifier.size(65.px).margin(all = 0.6.cssRem)) {
        Image(src = src, modifier = Modifier.size(42.px).then(modifier))
    }
}

@Composable
fun AppearanceAwareIconGlassBox(
    src: String,
    modifier: Modifier = Modifier,
    invert: Boolean = true,
) {
    GlassBox(modifier = Modifier.size(65.px).margin(all = 0.6.cssRem)) {
        AppearanceAwareImage(src = src, modifier = Modifier.size(42.px).then(modifier), invert = invert)
    }
}

/**
 * A composable function that displays a series of glass-like boxes, each containing an icon image.
 *
 * @param iconSources A variable number of image source descriptors to be displayed within the glass boxes.
 */
@Composable
fun IconGlassBoxes(vararg iconSources: IconSource) {
    iconSources.forEach { iconSource ->
        // If invert is null we render the regular Image, otherwise we render the appearance-aware variant.
        if (iconSource.invert == null) {
            IconGlassBox(iconSource.src, iconSource.modifier)
        } else {
            AppearanceAwareIconGlassBox(iconSource.src, iconSource.modifier, iconSource.invert)
        }
    }
}

/**
 * Simple representation of an icon source.
 *
 * - If [invert] is null -> treat as a regular image and render with [Image].
 * - If [invert] is non-null -> render with [AppearanceAwareImage] using the provided value.
 */
data class IconSource(
    val src: String,
    val modifier: Modifier = Modifier,
    val invert: Boolean? = null,
)

/**
 * Extension to quickly create a regular (non-appearance-aware) IconSource from a [String].
 */
val String.src: IconSource
    get() = IconSource(this)

/**
 * Create an appearance-aware IconSource. By default [invert] is true.
 */
fun String.appearance(
    invert: Boolean = true,
    modifier: Modifier = Modifier,
): IconSource = IconSource(this, modifier, invert)

/**
 * Backwards-compatible helper that matches the previous `withMod` usage. Prefer using `.appearance` or `.src`.
 */
fun String.withMod(
    invert: Boolean = true,
    modifier: Modifier = Modifier,
): IconSource = appearance(invert, modifier)
