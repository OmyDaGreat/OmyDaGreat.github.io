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
import xyz.malefic.utils.Constants
import xyz.malefic.utils.Res

@Composable
fun About() {
  Column(
    modifier = AboutStyle.toModifier().id("about"),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    SectionTitle(Constants.ABOUT_ME_TITLE)

    SpanText(
      text = Constants.ABOUT_ME_TEXT,
      modifier =
        SectionDescriptionStyle.toModifier()
          .textAlign(TextAlign.Center)
          .color(
            when (ColorMode.current) {
              ColorMode.LIGHT -> Colors.Gray
              ColorMode.DARK -> Colors.DimGray
            }
          )
          .fontFamily(Res.Fonts.DM_SANS),
    )
  }
}
