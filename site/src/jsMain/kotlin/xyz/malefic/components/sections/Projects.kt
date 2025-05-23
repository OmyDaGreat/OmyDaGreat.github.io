package xyz.malefic.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import xyz.malefic.components.styles.ProjectStyle
import xyz.malefic.components.widgets.AppearanceAwareImage
import xyz.malefic.components.widgets.RoundedImage
import xyz.malefic.components.widgets.SectionTitle
import xyz.malefic.components.widgets.SpanTextGray
import xyz.malefic.utils.Links
import xyz.malefic.utils.Res
import xyz.malefic.utils.getAllProjects

@Composable
fun Projects() {
    Column(
        modifier = ProjectStyle.toModifier().id("projects"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionTitle("My Side Projects.")

        SpanTextGray("I really have a bad habit of creating projects over projects XD")

        SimpleGrid(
            numColumns = numColumns(base = 1, sm = 2, md = 3),
            modifier = Modifier.fillMaxWidth().margin(top = 3.cssRem, bottom = 6.cssRem),
        ) {
            val allProjects = getAllProjects()

            repeat(allProjects.size) {
                val project = allProjects[it]
                RoundedImage(src = project.first, navigateTo = project.second)
            }

            Box(
                modifier = Modifier.fillMaxSize().padding(topBottom = 50.px),
                contentAlignment = Alignment.Center,
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Link(
                        path = Links.PROJECT_REPOSITORIES_URL,
                        text = "More on GitHub.",
                        modifier =
                            Modifier
                                .fontFamily(Res.Fonts.DM_SANS)
                                .color(
                                    when (ColorMode.current) {
                                        ColorMode.LIGHT -> Colors.Black
                                        ColorMode.DARK -> Colors.White
                                    },
                                ).margin(right = 4.px),
                    )
                    AppearanceAwareImage(src = Res.Images.NAVIGATION_ARROW)
                }
            }
        }
    }
}
