package com.ashan.cartnova.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ashan.cartnova.navigation.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawerScaffold(
    navController: NavHostController,
    content: @Composable () -> Unit
) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {

            ModalDrawerSheet {

                Text(
                    "CartNova",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(16.dp)
                )

                Divider()

                DrawerItem("Home", Icons.Default.Home) {
                    navController.navigate(ROUTE_HOME)
                }

                DrawerItem("Dashboard", Icons.Default.Dashboard) {
                    navController.navigate(ROUTE_DASHBOARD)
                }

                DrawerItem("Cart", Icons.Default.ShoppingCart) {
                    navController.navigate(ROUTE_CART)
                }

                DrawerItem("Payment", Icons.Default.CreditCard) {
                    navController.navigate(ROUTE_PAYMENT)
                }

                DrawerItem("Intent Hub", Icons.Default.Send) {
                    navController.navigate(ROUTE_INTENT)
                }

                DrawerItem("About", Icons.Default.Info) {
                    navController.navigate(ROUTE_ABOUT)
                }

                DrawerItem("Login", Icons.Default.Person) {
                    navController.navigate(ROUTE_LOGIN)
                }

            }
        }
    ) {
        content()
    }
}

@Composable
fun DrawerItem(title: String, icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {

    NavigationDrawerItem(
        label = { Text(title) },
        icon = { Icon(icon, contentDescription = null) },
        selected = false,
        onClick = onClick
    )
}

