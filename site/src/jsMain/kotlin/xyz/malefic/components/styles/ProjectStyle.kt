package xyz.malefic.components.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

val ProjectStyle =
    CssStyle {
        base { Modifier.width(100.percent).minHeight(100.vh) }
        Breakpoint.ZERO { Modifier.width(100.percent).minHeight(100.vh).margin(top = 100.px) }
        Breakpoint.SM { Modifier.width(100.percent).minHeight(100.vh).margin(top = 50.px) }
        Breakpoint.MD { Modifier.width(100.percent).minHeight(100.vh).margin(top = 0.px) }
        Breakpoint.LG { Modifier.width(100.percent).minHeight(100.vh) }
    }
