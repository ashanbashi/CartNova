package com.ashan.cartnova.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ashan.cartnova.ui.screens.about.AboutScreen
import com.ashan.cartnova.ui.screens.auth.LoginScreen
import com.ashan.cartnova.ui.screens.auth.RegisterScreen
import com.ashan.cartnova.ui.screens.contact.ContactScreen
import com.ashan.cartnova.ui.screens.home.HomeScreen
import com.ashan.cartnova.ui.screens.intent.IntentScreen
import com.ashan.cartnova.ui.screens.onboarding.OnBoardingScreen1
import com.ashan.cartnova.ui.screens.onboarding.OnBoardingScreen2
import com.ashan.cartnova.ui.screens.payment.PaymentScreen
import com.ashan.cartnova.ui.screens.splash.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }
        composable(ROUTE_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }
        composable(ROUTE_CONTACT) {
            ContactScreen(navController)
        }
        composable(ROUTE_ONBOARD1) {
            OnBoardingScreen1(navController)
        }
        composable(ROUTE_ONBOARD2) {
            OnBoardingScreen2(navController)
        }
        composable(ROUTE_PAYMENT) {
            PaymentScreen(navController)
        }
        composable(ROUTE_INTENT) {
            IntentScreen(navController)
        }
        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUTE_SCAFFOLD) {
            IntentScreen(navController)
        }


    }
}