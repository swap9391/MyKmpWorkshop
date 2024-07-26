package com.kocfour.mykmpworkshop.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kocfour.mykmpworkshop.ui.screens.home.tabs.HomeScreen
import com.kocfour.mykmpworkshop.ui.screens.home.tabs.ListScreen
import com.kocfour.mykmpworkshop.ui.screens.home.tabs.ProfileScreen
import com.kocfour.mykmpworkshop.ui.screens.home.tabs.SearchScreen
import com.kocfour.mykmpworkshop.ui.screens.home.nav.NavItem

/**
 * Composable function that defines the navigation screens and their corresponding destinations.
 *
 * @param navController The navigation controller used for handling navigation between screens.
 */
@Composable
fun NavigationScreens(navController: NavHostController) {
    NavHost(navController, startDestination = NavItem.Home.path) {
        composable(NavItem.Home.path) { HomeScreen() }
        composable(NavItem.Search.path) { SearchScreen() }
        composable(NavItem.List.path) { ListScreen() }
        composable(NavItem.Profile.path) { ProfileScreen() }
    }
}