package com.kocfour.mykmpworkshop.ui.screens.home.nav

import com.kocfour.mykmpworkshop.R

sealed class NavItem {
    object Home :
        Item(path = NavPath.HOME.toString(), title = R.string.text_home, icon = R.drawable.ic_home)

    object Search :
        Item(path = NavPath.ANALYSIS.toString(), title = R.string.text_analysis, icon = R.drawable.ic_analysis)

    object List :
        Item(path = NavPath.SETTINGS.toString(), title = R.string.text_settings, icon = R.drawable.ic_settings)

    object Profile :
        Item(
            path = NavPath.PROFILE.toString(), title = R.string.text_profile, icon = R.drawable.ic_profile)
}