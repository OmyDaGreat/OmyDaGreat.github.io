package xyz.malefic.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
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
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import xyz.malefic.components.styles.ProjectStyle
import xyz.malefic.components.widgets.AppearanceAwareImage
import xyz.malefic.components.widgets.RoundedImage
import xyz.malefic.components.widgets.SectionTitle
import xyz.malefic.components.widgets.SpanTextGray
import xyz.malefic.utils.Links
import xyz.malefic.utils.Res
import xyz.malefic.utils.getAllCompose
import xyz.malefic.utils.switchOpposite

@Composable
fun MaleficCompose() {
    Column(
        modifier = ProjectStyle.toModifier().id("maleficcompose"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionTitle("MaleficCompose")

        SpanTextGray("I go by Malefic online")

        SpanTextGray("MaleficCompose is a Github organization I have created dedicated to furthering Compose for Desktop utilities")

        SimpleGrid(
            numColumns = numColumns(base = 1, sm = 2, md = 3),
            modifier = Modifier.fillMaxWidth().margin(top = 3.cssRem, bottom = 6.cssRem),
        ) {
            val allCompose = getAllCompose()

            repeat(allCompose.size) {
                val compose = allCompose[it]
                RoundedImage(src = compose.first, navigateTo = compose.second)
            }

            Box(
                modifier = Modifier.fillMaxSize().padding(topBottom = 50.px),
                contentAlignment = Alignment.Center,
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Link(
                        path = Links.COMPOSE_REPOSITORIES_URL,
                        text = "More on GitHub.",
                        modifier =
                            Modifier
                                .fontFamily(Res.Fonts.DM_SANS)
                                .color(switchOpposite())
                                .margin(right = 4.px),
                    )
                    AppearanceAwareImage(src = Res.Images.NAVIGATION_ARROW)
                }
            }
        }
    }
}
