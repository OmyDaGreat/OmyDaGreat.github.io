package xyz.malefic.components.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val ButtonStyle = CssStyle {
  base {
    Modifier.padding(leftRight = 20.px)
      .transition(
        Transition.of(
          property = TransitionProperty.All,
          duration = 300.ms,
          timingFunction = null,
          delay = null,
        )
      )
  }
  hover { Modifier.padding(leftRight = 30.px) }
}
