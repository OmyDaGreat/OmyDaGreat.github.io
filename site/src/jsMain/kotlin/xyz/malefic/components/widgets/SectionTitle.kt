package xyz.malefic.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import xyz.malefic.SubheadlineTextStyle
import xyz.malefic.components.styles.SectionTitleStyle
import xyz.malefic.utils.Res
import xyz.malefic.utils.switchInvert
import xyz.malefic.utils.switchOpposite

@Composable
fun SectionTitle(
    sectionTitleText: String,
    mod: Modifier = Modifier,
) {
    Row {
        Div(SubheadlineTextStyle.toAttrs()) {
            SpanText(
                text = sectionTitleText,
                modifier =
                    SectionTitleStyle
                        .toModifier()
                        .align(Alignment.Bottom)
                        .color(switchOpposite())
                        .fontWeight(FontWeight.Bold)
                        .then(mod),
            )
        }
        Image(
            src = Res.Images.PORTAL_STAR,
            modifier =
                Modifier
                    .align(Alignment.Top)
                    .size(22.px)
                    .then(switchInvert()),
        )
    }
}
