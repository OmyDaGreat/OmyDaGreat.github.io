package xyz.malefic

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.color
import xyz.malefic.theme.ThemeColors

/**
 * @property nearBackground A useful color to apply to a container that should differentiate itself
 *   from the background but just a little.
 */
class SitePalette(
    val nearBackground: Color,
    val cobweb: Color,
    val brand: Brand,
) {
    class Brand(
        val primary: Color,
        val accent: Color,
    )
}

object SitePalettes {
    val light =
        SitePalette(
            nearBackground = ThemeColors.Background.nearBackgroundLight,
            cobweb = ThemeColors.Border.cobwebLight,
            brand = SitePalette.Brand(
                primary = ThemeColors.Brand.primaryLight,
                accent = ThemeColors.Brand.accentLight
            ),
        )
    val dark =
        SitePalette(
            nearBackground = ThemeColors.Background.nearBackgroundDark,
            cobweb = ThemeColors.Border.cobwebDark,
            brand = SitePalette.Brand(
                primary = ThemeColors.Brand.primaryDark,
                accent = ThemeColors.Brand.accentDark
            ),
        )
}

fun ColorMode.toSitePalette(): SitePalette =
    when (this) {
        ColorMode.LIGHT -> SitePalettes.light
        ColorMode.DARK -> SitePalettes.dark
    }

@InitSilk
fun initTheme(ctx: InitSilkContext) {
    ctx.theme.palettes.light.background = ThemeColors.Background.light
    ctx.theme.palettes.light.color = ThemeColors.Text.light
    ctx.theme.palettes.dark.background = ThemeColors.Background.dark
    ctx.theme.palettes.dark.color = ThemeColors.Text.dark
}
