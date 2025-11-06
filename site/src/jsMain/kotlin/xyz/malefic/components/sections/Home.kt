package xyz.malefic.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonSize
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.Div
import xyz.malefic.HeadlineTextStyle
import xyz.malefic.SubheadlineTextStyle
import xyz.malefic.components.styles.*
import xyz.malefic.theme.secondaryText
import xyz.malefic.theme.text
import xyz.malefic.utils.CustomColorSchemes
import xyz.malefic.utils.Links
import xyz.malefic.utils.Res

@Composable
fun Home() {
    Box(
        modifier =
            HeroSectionStyle
                .toModifier()
                .animation(
                    HeroContainerKeyFrames.toAnimation(
                        duration = 1.s,
                        timingFunction = AnimationTimingFunction.EaseInOut,
                    ),
                ),
        contentAlignment = Alignment.CenterStart,
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            SpanText(
                text = "Hi, I'm",
                modifier =
                    HelloImStyle
                        .toModifier()
                        .color(ColorMode.current.secondaryText())
                        .fontWeight(FontWeight.Bold),
            )
            SpanText(
                text = "Om Gupta",
                modifier =
                    UserNameStyle
                        .toModifier()
                        .color(ColorMode.current.text())
                        .fontWeight(FontWeight.Bold),
            )

            Div(SubheadlineTextStyle.toModifier().margin(top = 20.px).toAttrs()) {
                SpanText(
                    text = "and it's nice to meet you!",
                    modifier =
                        UsersMessageStyle
                            .toModifier()
                            .color(ColorMode.current.secondaryText())
                            .fontFamily(Res.Fonts.DM_SANS),
                )
            }

            val ctx = rememberPageContext()

            Div(HeadlineTextStyle.toAttrs()) {
                Button(
                    onClick = { ctx.router.navigateTo(Links.RESUME_URL) },
                    colorPalette = CustomColorSchemes.BlackAndWhite,
                    size = ButtonSize.MD,
                    modifier = ButtonStyle.toModifier().width(150.percent).margin(top = 70.px),
                ) {
                    SpanText(text = "Resume", modifier = Modifier.fontFamily(Res.Fonts.TAURI))
                }
            }
        }
    }
}
