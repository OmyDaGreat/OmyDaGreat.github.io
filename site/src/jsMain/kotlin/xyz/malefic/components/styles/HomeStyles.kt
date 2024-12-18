package xyz.malefic.components.styles

import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

val HeroSectionStyle = CssStyle {
  base { Modifier.width(100.percent).fontSize(3.cssRem).height(100.vh) }
  Breakpoint.ZERO { Modifier.width(100.percent).fontSize(2.5.cssRem).height(50.vh) }
  Breakpoint.SM { Modifier.width(100.percent).fontSize(2.5.cssRem).height(50.vh) }
  Breakpoint.MD { Modifier.width(100.percent).fontSize(2.75.cssRem).height(85.vh) }
  Breakpoint.LG { Modifier.width(100.percent).fontSize(3.cssRem).height(100.vh) }
}

val HelloImStyle = CssStyle {
  base { Modifier.fontSize(FontSize.Medium).margin(top = 2.cssRem) }
  Breakpoint.SM { Modifier.fontSize(FontSize.Large) }
  Breakpoint.MD { Modifier.fontSize(FontSize.XLarge) }
  Breakpoint.LG { Modifier.fontSize(FontSize.XXLarge) }
}

val UserNameStyle = CssStyle {
  base { Modifier.fontSize(FontSize.XLarge) }
  Breakpoint.SM { Modifier.fontSize(FontSize.XXLarge) }
  Breakpoint.MD { Modifier.fontSize(FontSize.Larger) }
  Breakpoint.LG { Modifier.fontSize(FontSize.Larger) }
}

val UsersMessageStyle = CssStyle {
  base { Modifier.fontSize(FontSize.Medium) }
  Breakpoint.SM { Modifier.fontSize(FontSize.Large) }
  Breakpoint.MD { Modifier.fontSize(FontSize.Large) }
  Breakpoint.LG { Modifier.fontSize(FontSize.XLarge) }
}

val HeroContainerKeyFrames = Keyframes {
  0.percent { Modifier.margin(top = 50.px).opacity(0) }
  100.percent { Modifier.margin(top = 0.px).opacity(1) }
}
