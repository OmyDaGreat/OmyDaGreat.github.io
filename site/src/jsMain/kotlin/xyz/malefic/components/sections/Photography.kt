package xyz.malefic.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px
import xyz.malefic.components.styles.ExperienceStyle
import xyz.malefic.components.widgets.PhotographImage
import xyz.malefic.components.widgets.SectionTitle
import xyz.malefic.utils.getAllPhotographs

@Composable
fun Photography() {
    Column(
        modifier = ExperienceStyle.toModifier().id("photography"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionTitle("Sometimes I love to click.")

        SimpleGrid(
            modifier = Modifier.margin(top = 30.px),
            numColumns = numColumns(base = 1, sm = 2, md = 4, lg = 6),
        ) {
            val allPhotographs = getAllPhotographs()

            repeat(allPhotographs.size) { PhotographImage(src = allPhotographs[it]) }
        }
    }
}
