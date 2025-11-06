package xyz.malefic.utils

import com.varabyte.kobweb.silk.theme.colors.ColorPalette
import xyz.malefic.theme.ThemeColors

object CustomColorSchemes {
    val BlackAndWhite =
        object : ColorPalette {
            override val _50 = ThemeColors.Button.blackAndWhiteLight
            override val _100 = ThemeColors.Button.blackAndWhiteLight
            override val _200 = ThemeColors.Button.blackAndWhiteLight
            override val _300 = ThemeColors.Button.blackAndWhiteLight
            override val _400 = ThemeColors.Button.blackAndWhiteLight
            override val _500 = ThemeColors.Button.blackAndWhiteDark
            override val _600 = ThemeColors.Button.blackAndWhiteDark
            override val _700 = ThemeColors.Button.blackAndWhiteDark
            override val _800 = ThemeColors.Button.blackAndWhiteDark
            override val _900 = ThemeColors.Button.blackAndWhiteDark
        }
}
