package xyz.malefic.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import xyz.malefic.components.styles.AboutStyle
import xyz.malefic.components.styles.SectionDescriptionStyle
import xyz.malefic.components.widgets.SectionTitle
import xyz.malefic.components.widgets.SpanTextGray
import xyz.malefic.theme.secondaryText
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
                "I am a systems-focused developer who designs invisible infrastructure that makes complex tools accessible and reliable. I specialize in creating documentation, templates, and frameworks that optimize workflows and enable others to build efficiently, and I study existing systems to understand how to balance simplicity with customization for different user needs.",
            modifier =
                SectionDescriptionStyle
                    .toModifier()
                    .textAlign(TextAlign.Center)
                    .color(ColorMode.current.secondaryText())
                    .fontFamily(Res.Fonts.DM_SANS),
        )

        SpanTextGray("I also go by Malefic online!")
    }
}
