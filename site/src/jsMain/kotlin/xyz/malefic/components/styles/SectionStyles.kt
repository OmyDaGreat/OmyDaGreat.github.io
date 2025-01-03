package xyz.malefic.components.styles

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import xyz.malefic.utils.Res
import xyz.malefic.utils.switchGray

val SectionTitleStyle =
    CssStyle {
        base { Modifier.fontSize(FontSize.Large) }
        Breakpoint.SM { Modifier.fontSize(FontSize.Large) }
        Breakpoint.MD { Modifier.fontSize(FontSize.XLarge) }
        Breakpoint.LG { Modifier.fontSize(FontSize.XXLarge) }
    }

val SectionDescriptionStyle =
    CssStyle {
        base { Modifier.fontSize(FontSize.XSmall).margin(topBottom = 0.75.cssRem) }
        Breakpoint.SM { Modifier.fontSize(FontSize.Small).margin(topBottom = 0.75.cssRem) }
        Breakpoint.MD { Modifier.fontSize(FontSize.Medium).margin(topBottom = 1.cssRem) }
        Breakpoint.LG { Modifier.fontSize(FontSize.Large).margin(topBottom = 2.cssRem) }
    }

val GrayStyle
    @Composable
    get() =
        SectionDescriptionStyle
            .toModifier()
            .textAlign(TextAlign.Center)
            .color(switchGray())
            .fontFamily(Res.Fonts.DM_SANS)
