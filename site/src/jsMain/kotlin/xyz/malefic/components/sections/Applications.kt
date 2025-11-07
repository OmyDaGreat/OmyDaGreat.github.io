package xyz.malefic.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import xyz.malefic.components.styles.ProjectStyle
import xyz.malefic.components.widgets.RoundedImage
import xyz.malefic.components.widgets.SectionTitle
import xyz.malefic.components.widgets.SpanTextGray
import xyz.malefic.utils.getAllCompose

@Composable
fun Applications() {
    Column(
        modifier = ProjectStyle.toModifier().id("applications"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionTitle("Applications")

        SpanTextGray("MaleficCompose is a Github organization I have created dedicated to furthering Compose for Desktop utilities")

        SimpleGrid(
            numColumns = numColumns(base = 1, sm = 2, md = 3),
            modifier = Modifier.fillMaxWidth().margin(top = 3.cssRem, bottom = 6.cssRem),
        ) {
            repeat(getAllCompose().size) {
                val compose = getAllCompose()[it]
                RoundedImage(src = compose.first, navigateTo = compose.second)
            }
        }
    }
}
