package xyz.malefic.utils

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode

/**
 * A composable function that returns a value based on the current color mode.
 *
 * This function evaluates the current `ColorMode` and returns `ifLight` if the mode is light,
 * or `ifDark` if the mode is dark. It uses reified type parameters to ensure type safety.
 *
 * @param ifLight The value to return when the color mode is light.
 * @param ifDark The value to return when the color mode is dark.
 * @return The value corresponding to the current color mode.
 */
@Composable
inline fun <reified T> switch(
    ifLight: T,
    ifDark: T,
) = when (ColorMode.current) {
    ColorMode.LIGHT -> ifLight
    ColorMode.DARK -> ifDark
}

/**
 * A composable function that applies an invert filter to the UI component.
 *
 * This function uses the `switch` utility to apply a CSS filter that inverts
 * colors when the color mode is light, and applies no filter when the color
 * mode is dark.
 *
 * @return A `Modifier` with the invert filter applied based on the color mode.
 */
@Composable
fun switchInvert() = switch(Modifier.styleModifier { property("filter", "invert(1)") }, Modifier)

/**
 * A composable function that returns a gray color based on the current color mode.
 *
 * This function uses the `switch` utility to return `Colors.Gray` when the color mode
 * is light, and `Colors.DimGray` when the color mode is dark.
 *
 * @return The gray color corresponding to the current color mode.
 */
@Composable
fun switchGray() = switch(Colors.Gray, Colors.DimGray)

/**
 * A composable function that returns a color opposite to the current color mode.
 *
 * This function uses the `switch` utility to return `Colors.Black` when the color mode
 * is light, and `Colors.White` when the color mode is dark.
 *
 * @return The opposite color corresponding to the current color mode.
 */
@Composable
fun switchOpposite() = switch(Colors.Black, Colors.White)
