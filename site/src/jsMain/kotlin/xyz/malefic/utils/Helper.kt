package xyz.malefic.utils

fun getAllApplications() =
    listOf(
        Res.Images.PROJECT_ARIES to Links.PROJECT_ARIES_URL,
        Res.Images.PROJECT_LEVIATHAN to Links.PROJECT_LEVIATHAN_URL,
        Res.Images.PROJECT_HELLS_KITCHEN to Links.PROJECT_HELLS_KITCHEN_URL,
        Res.Images.PROJECT_SPLITLY to Links.PROJECT_SPLITLY_URL,
        Res.Images.PROJECT_REEFSCAPE to Links.PROJECT_REEFSCAPE_URL,
    )

fun getAllCompose() =
    listOf(
        Pair(Res.Images.COMPOSE_CDT, Links.COMPOSE_CDT_URL),
        Pair(Res.Images.COMPOSE_NAV, Links.COMPOSE_NAV_URL),
        Pair(Res.Images.COMPOSE_COMPS, Links.COMPOSE_COMPS_URL),
        Pair(Res.Images.COMPOSE_PREFS, Links.COMPOSE_PREFS_URL),
        Pair(Res.Images.COMPOSE_THEMING, Links.COMPOSE_THEMING_URL),
        Pair(Res.Images.COMPOSE_ENGINE, Links.COMPOSE_ENGINE_URL),
    )
