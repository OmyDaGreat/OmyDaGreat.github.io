package xyz.malefic.theme

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.silk.theme.colors.ColorMode

/**
 * Centralized theme colors configuration.
 * Edit these values to change the color scheme of the entire site.
 */
object ThemeColors {
    // Brand colors
    object Brand {
        val primaryLight = Color.rgb(0x3C83EF)
        val primaryDark = Color.rgb(0x3C83EF)
        val accentLight = Color.rgb(0xFCBA03)
        val accentDark = Color.rgb(0xF3DB5B)
    }

    // Background colors
    object Background {
        val light = Color.rgb(0xFAFAFA)
        val dark = Color.rgb(0x06080B)
        val nearBackgroundLight = Color.rgb(0xF4F6FA)
        val nearBackgroundDark = Color.rgb(0x13171F)
        val footerLight = Color.rgb(0xF1F1F1)
        val footerDark = Color.rgb(0x0D0D0D)
    }

    // Text colors
    object Text {
        val light = Colors.Black
        val dark = Colors.White
        val secondaryLight = Colors.Gray
        val secondaryDark = Colors.DimGray
    }

    // Border colors
    object Border {
        val glassBoxLight = Color.rgb(0xE9E9E9)
        val glassBoxDark = Color.rgb(0x4E4E4E)
        val cobwebLight = Colors.LightGray
        val cobwebDark = Colors.LightGray.inverted()
    }

    // Button colors
    object Button {
        val blackAndWhiteLight = Color.rgb(0xFFFFFF)
        val blackAndWhiteDark = Color.rgb(0x000000)
        val transparent = Colors.Transparent
    }
}

/**
 * Helper extension functions for color mode switching
 */
@Composable
fun ColorMode.primary() =
    when (this) {
        ColorMode.LIGHT -> ThemeColors.Brand.primaryLight
        ColorMode.DARK -> ThemeColors.Brand.primaryDark
    }

@Composable
fun ColorMode.accent() =
    when (this) {
        ColorMode.LIGHT -> ThemeColors.Brand.accentLight
        ColorMode.DARK -> ThemeColors.Brand.accentDark
    }

@Composable
fun ColorMode.background() =
    when (this) {
        ColorMode.LIGHT -> ThemeColors.Background.light
        ColorMode.DARK -> ThemeColors.Background.dark
    }

@Composable
fun ColorMode.nearBackground() =
    when (this) {
        ColorMode.LIGHT -> ThemeColors.Background.nearBackgroundLight
        ColorMode.DARK -> ThemeColors.Background.nearBackgroundDark
    }

@Composable
fun ColorMode.footer() =
    when (this) {
        ColorMode.LIGHT -> ThemeColors.Background.footerLight
        ColorMode.DARK -> ThemeColors.Background.footerDark
    }

@Composable
fun ColorMode.text() =
    when (this) {
        ColorMode.LIGHT -> ThemeColors.Text.light
        ColorMode.DARK -> ThemeColors.Text.dark
    }

@Composable
fun ColorMode.secondaryText() =
    when (this) {
        ColorMode.LIGHT -> ThemeColors.Text.secondaryLight
        ColorMode.DARK -> ThemeColors.Text.secondaryDark
    }

@Composable
fun ColorMode.glassBoxBorder() =
    when (this) {
        ColorMode.LIGHT -> ThemeColors.Border.glassBoxLight
        ColorMode.DARK -> ThemeColors.Border.glassBoxDark
    }

@Composable
fun ColorMode.cobweb() =
    when (this) {
        ColorMode.LIGHT -> ThemeColors.Border.cobwebLight
        ColorMode.DARK -> ThemeColors.Border.cobwebDark
    }
