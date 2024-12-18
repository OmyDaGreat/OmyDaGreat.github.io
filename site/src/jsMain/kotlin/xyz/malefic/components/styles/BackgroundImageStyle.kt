package xyz.malefic.components.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent

val BackgroundImageStyle = CssStyle {
  base { Modifier.scale(25.percent) }
  Breakpoint.SM { Modifier.scale(50.percent) }
  Breakpoint.MD { Modifier.scale(75.percent) }
  Breakpoint.LG { Modifier.scale(100.percent) }
}
