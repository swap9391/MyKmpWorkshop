package com.kocfour.mykmpworkshop.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kocfour.mykmpworkshop.ui.components.bottomnavigation.BottomNavigationBar
import com.kocfour.mykmpworkshop.ui.screens.home.nav.NavItem
import com.kocfour.mykmpworkshop.ui.screens.home.tabs.AnalysisTab
import com.kocfour.mykmpworkshop.ui.screens.home.tabs.HomeTab
import com.kocfour.mykmpworkshop.ui.screens.home.tabs.ProfileTab
import com.kocfour.mykmpworkshop.ui.screens.home.tabs.SettingsTab
import com.kocfour.mykmpworkshop.ui.theme.ComposeWorkShopTheme

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    ComposeWorkShopTheme {
    Scaffold(bottomBar = {
        BottomAppBar { BottomNavigationBar(navController = navController) }
    }) {innerPadding ->
        NavHost(navController, startDestination = NavItem.Home.path,Modifier.padding(innerPadding)) {
            composable(NavItem.Home.path) { HomeTab() }
            composable(NavItem.Search.path) { AnalysisTab() }
            composable(NavItem.List.path) { SettingsTab() }
            composable(NavItem.Profile.path) { ProfileTab() }
        }
    }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeWorkShopTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            HomeScreen()
        }
    }
}