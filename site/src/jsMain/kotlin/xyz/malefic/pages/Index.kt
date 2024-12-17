package xyz.malefic.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.compose.foundation.layout.*
import xyz.malefic.components.layouts.PageLayout
import xyz.malefic.components.sections.*
import xyz.malefic.utils.Res

@Page
@Composable
fun HomePage() {
    PageLayout("Home") {
        Row(
            Modifier.fillMaxWidth().fontFamily(Res.Fonts.Space_Grotesk).id("home")
        ) {
            Box {

                Column {

                    Home()

                    About()

                    Experience()

                    SkillsAndTools()

                    Photography()

                    Projects()
                }
            }
        }
    }
}
