package com.ashan.cartnova.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.ashan.cartnova.ui.screens.splash.SplashScreen
import com.ashan.cartnova.ui.screens.onboarding.OnBoardingScreen1
import com.ashan.cartnova.ui.screens.onboarding.OnBoardingScreen2

import com.ashan.cartnova.ui.screens.auth.LoginScreen
import com.ashan.cartnova.ui.screens.auth.RegisterScreen

import com.ashan.cartnova.ui.screens.dashboard.DashboardScreen
import com.ashan.cartnova.ui.screens.home.HomeScreen
import com.ashan.cartnova.ui.screens.about.AboutScreen
import com.ashan.cartnova.ui.screens.intent.IntentScreen
import com.ashan.cartnova.ui.screens.cards.BusinessCards

import com.ashan.cartnova.ui.screens.product.ProductScreen
import com.ashan.cartnova.ui.screens.cart.CartScreen
import com.ashan.cartnova.ui.screens.payment.PaymentScreen
import com.ashan.cartnova.ui.screens.products.AddProductScreen
import com.ashan.cartnova.ui.screens.products.UpdateProductScreen
import com.ashan.cartnova.ui.screens.products.ViewProductScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = ROUTE_SPLASH
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        // 🔥 SPLASH
        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }

        // 🎯 ONBOARDING
        composable(ROUTE_ONBOARD1) {
            OnBoardingScreen1(navController)
        }

        composable(ROUTE_ONBOARD2) {
            OnBoardingScreen2(navController)
        }

        // 🔐 AUTH
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }

        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }

        // 🧭 MAIN DASHBOARD
        composable(ROUTE_DASHBOARD) {
            DashboardScreen(navController)
        }

        // 🏠 HOME (PRODUCT LIST)
        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }

        // ℹ ABOUT
        composable(ROUTE_ABOUT) {
            AboutScreen(navController)
        }

        // 📞 INTENTS SCREEN
        composable(ROUTE_INTENT) {
            IntentScreen(navController)
        }

        // 💳 BUSINESS CARDS
        composable("cards") {
            BusinessCards(navController)
        }

        // 🛍 PRODUCT DETAILS
        composable(ROUTE_PRODUCT) {
            ProductScreen(navController)
        }

        // 🛒 CART
        composable(ROUTE_CART) {
            CartScreen(navController)
        }

        // 💰 PAYMENT
        composable(ROUTE_PAYMENT) {
            PaymentScreen(navController)
        }

        composable(ROUTE_ADD_PRODUCT) { AddProductScreen(navController) }

        composable(ROUTE_VIEW_PRODUCTS) { ViewProductScreen(navController) }

        composable(
            ROUTE_UPDATE_PRODUCT,
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")!!
            UpdateProductScreen(navController, productId)
        }
    }
}