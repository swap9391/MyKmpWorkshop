package com.kocfour.mykmpworkshop.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kocfour.mykmpworkshop.ui.screens.home.nav.NavItem
import com.kocfour.mykmpworkshop.ui.screens.home.tabs.AnalysisTab
import com.kocfour.mykmpworkshop.ui.screens.home.tabs.HomeTab
import com.kocfour.mykmpworkshop.ui.screens.home.tabs.ProfileTab
import com.kocfour.mykmpworkshop.ui.screens.home.tabs.SettingsTab

/**
 * Composable function that defines the navigation screens and their corresponding destinations.
 *
 * @param navController The navigation controller used for handling navigation between screens.
 */
@Composable
fun NavigationScreens(navController: NavHostController) {
    NavHost(navController, startDestination = NavItem.Home.path) {
        composable(NavItem.Home.path) { HomeTab() }
        composable(NavItem.Search.path) { AnalysisTab() }
        composable(NavItem.List.path) { SettingsTab() }
        composable(NavItem.Profile.path) { ProfileTab() }
    }
}