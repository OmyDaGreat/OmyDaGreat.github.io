package xyz.malefic.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import xyz.malefic.components.layouts.PageLayout
import xyz.malefic.components.sections.*
import xyz.malefic.utils.Res

@Page
@Composable
fun HomePage() {
    PageLayout("Home") {
        Row(Modifier.fillMaxWidth().fontFamily(Res.Fonts.SPACE_GROTESK).id("home")) {
            Box {
                Column {
                    Home()

                    About()

                    SkillsAndTools()

                    Photography()

                    Projects()

                    MaleficCompose()
                }
            }
        }
    }
}
