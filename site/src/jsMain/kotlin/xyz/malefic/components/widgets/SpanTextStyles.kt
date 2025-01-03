package xyz.malefic.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.text.SpanText
import xyz.malefic.components.styles.GrayStyle

/**
 * A composable function that displays a span of text styled with the [GrayStyle].
 *
 * @param text The text content to be displayed within the span.
 */
@Composable
fun SpanTextGray(
    text: String,
    mod: Modifier = Modifier,
) {
    SpanText(text, GrayStyle.then(mod))
}
