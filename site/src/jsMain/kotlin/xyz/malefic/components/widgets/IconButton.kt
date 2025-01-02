package xyz.malefic.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonVars
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.em
import xyz.malefic.CircleButtonVariant
import xyz.malefic.UncoloredButtonVariant

@Composable
fun IconButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Button(
        onClick = { onClick() },
        Modifier.setVariable(
            ButtonVars.FontSize,
            1.em,
        ), // Make button icon size relative to parent container font size
        variant = CircleButtonVariant.then(UncoloredButtonVariant),
    ) {
        content()
    }
}

val FooterIconsStyle =
    CssStyle {
        hover {
            Modifier.scale(1.1) // TODO: Try changing color on hover
        }
    }

@Composable
fun IconButtonNoHover(
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Button(
        onClick = { onClick() },
        FooterIconsStyle
            .toModifier()
            .setVariable(ButtonVars.FontSize, 1.em)
            .backgroundColor(
                Colors.Transparent,
            ), // Make button icon size relative to parent container font size
        variant = CircleButtonVariant.then(UncoloredButtonVariant),
    ) {
        content()
    }
}
