package xyz.malefic.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.MixBlendMode
import com.varabyte.kobweb.compose.css.mixBlendMode
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import xyz.malefic.components.styles.ExperienceStyle
import xyz.malefic.components.widgets.GlassBox
import xyz.malefic.components.widgets.SectionTitle
import xyz.malefic.utils.Constants
import xyz.malefic.utils.Res

@Composable
fun SkillsAndTools() {
    Column(
        modifier = ExperienceStyle.toModifier().id("skills_and_tools"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionTitle(Constants.SKILLS_AND_TOOLS_TITLE)

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
                            KOTLIN_LOGO.withMod(Modifier.styleModifier { mixBlendMode(MixBlendMode.Normal) }),
                            JAVA_LOGO.src,
                            HTML_LOGO.src,
                            CSS_LOGO.src,
                            JAVASCRIPT_LOGO.src,
                            EXPRESS_LOGO.src,
                            NODEJS_LOGO.src,
                            MARKDOWN_LOGO.src,
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
                            ANDROID_LOGO.src,
                            INTELLIJ_LOGO.src,
                            FIGMA_LOGO.src,
                            FIREBASE_LOGO.src,
                            MONGODB_LOGO.src,
                            VSCODE_LOGO.src,
                            GIT_LOGO.src,
                            POSTMAN_LOGO.src,
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

/**
 * A composable function that displays a series of glass-like boxes, each containing an icon image.
 *
 * @param iconSources A variable number of image source URLs to be displayed within the glass boxes.
 */
@Composable
fun IconGlassBoxes(vararg iconSources: IconSource) {
    iconSources.forEach { iconSource ->
        when (iconSource) {
            is IconSource.Single -> {
                IconGlassBox(iconSource.string)
            }
            is IconSource.WithModifier -> {
                IconGlassBox(iconSource.string, iconSource.modifier)
            }
        }
    }
}

/**
 * Represents a source for an icon, which can either be a single source or a source with an
 * additional modifier.
 *
 * @property Single A single icon source represented by a URL or path.
 * @property WithModifier An icon source with an associated modifier for additional styling or
 *   behavior.
 */
sealed class IconSource {
    data class Single(
        val string: String,
    ) : IconSource()

    data class WithModifier(
        val string: String,
        val modifier: Modifier,
    ) : IconSource()
}

/**
 * Extension property to convert a string into an [IconSource.Single].
 *
 * @return An [IconSource.Single] containing the string.
 * @receiver The string representing the icon source URL or path.
 */
val String.src: IconSource
    get() = IconSource.Single(this)

/**
 * Converts a string into an IconSource with an associated modifier.
 *
 * @param modifier A [Modifier] to be applied for additional styling or behavior.
 * @return An [IconSource.WithModifier] containing the string and the modifier.
 * @receiver The string representing the icon source URL or path.
 */
fun String.withMod(modifier: Modifier): IconSource = IconSource.WithModifier(this, modifier)
