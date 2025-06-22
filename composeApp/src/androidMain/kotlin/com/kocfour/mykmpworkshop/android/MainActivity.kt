package com.kocfour.mykmpworkshop.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kocfour.mykmpworkshop.ui.screens.home.HomeScreen
import com.kocfour.mykmpworkshop.ui.screens.home.setgoalwithai.SetGoalWithAI
import com.kocfour.mykmpworkshop.ui.screens.usermanagement.EmailVerificationScreen
import com.kocfour.mykmpworkshop.ui.screens.usermanagement.EmailVerificationSuccessScreen
import com.kocfour.mykmpworkshop.ui.screens.usermanagement.LogInScreen
import com.kocfour.mykmpworkshop.ui.screens.usermanagement.MySplashScreen
import com.kocfour.mykmpworkshop.ui.screens.usermanagement.SignUpScreen
import com.kocfour.mykmpworkshop.ui.screens.onboarding.WelcomeSlideViewScreen
import com.kocfour.mykmpworkshop.ui.theme.ComposeWorkShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWorkShopTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    val navHostController = rememberNavController()

                    NavHost(
                        navController = navHostController,
                        startDestination = AppConstants.KEY_NAVIGATE_SPLASH
                    ) {
                        composable(AppConstants.KEY_NAVIGATE_SPLASH) {
                            //MySplashScreen(navHostController)
                            HomeScreen(navHostController)
                        }
                        composable(AppConstants.KEY_NAVIGATE_LOGIN) {
                            LogInScreen(navHostController)
                        }
                        composable(AppConstants.KEY_NAVIGATE_SIGNUP) {
                            SignUpScreen(navHostController)
                        }

                        composable(AppConstants.KEY_NAVIGATE_ONBOARDING) {
                            WelcomeSlideViewScreen(navHostController)
                        }

                        composable(AppConstants.KEY_NAVIGATE_VERIFICATION) {
                            EmailVerificationScreen(navHostController)
                        }

                        composable(AppConstants.KEY_NAVIGATE_VERIFICATION_SUCCESS) {
                            EmailVerificationSuccessScreen(navHostController)
                        }

                        composable(AppConstants.KEY_NAVIGATE_HOME) {
                            HomeScreen(navHostController)
                        }

                        composable(AppConstants.KEY_NAVIGATE_SET_GOAL) {
                            SetGoalWithAI(navHostController)
                        }

                    }

                }
                //MySplashScreen(getString(R.string.text_drop_water_tracker), getString(R.string.text_drop_water_tracker_subtitle))
            }

        }
    }
}

