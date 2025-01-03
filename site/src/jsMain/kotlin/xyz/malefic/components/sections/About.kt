package xyz.malefic.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import xyz.malefic.components.styles.AboutStyle
import xyz.malefic.components.styles.SectionDescriptionStyle
import xyz.malefic.components.widgets.SectionTitle
import xyz.malefic.utils.Res

@Composable
fun About() {
    Column(
        modifier = AboutStyle.toModifier().id("about"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionTitle("About me.")

        SpanText(
            text =
                "I am a versatile software developer proficient in desktop and mobile development. I have a strong" +
                    " foundation in software development, and I am always eager to learn new technologies. I am a qui" +
                    "ck learner and a team player who is passionate about software development and always ready to ta" +
                    "ke on new challenges.",
            modifier =
                SectionDescriptionStyle
                    .toModifier()
                    .textAlign(TextAlign.Center)
                    .color(
                        when (ColorMode.current) {
                            ColorMode.LIGHT -> Colors.Gray
                            ColorMode.DARK -> Colors.DimGray
                        },
                    ).fontFamily(Res.Fonts.DM_SANS),
        )
    }
}
