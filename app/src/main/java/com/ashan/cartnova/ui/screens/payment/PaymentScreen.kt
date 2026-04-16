package com.ashan.cartnova.ui.screens.payment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        TopAppBar(
            title = { Text("Home") },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Menu, contentDescription = "menu")
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.ShoppingCart, contentDescription = "cart")
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Notifications, contentDescription = "notifications")
                }
            },
            colors = topAppBarColors(
                containerColor = _root_ide_package_.com.ashan.cartnova.ui.theme.Pink40,
                navigationIconContentColor = Color.White,
                actionIconContentColor = Color.White,
                titleContentColor = Color.White
            )

        )

    }
}


@Preview(showBackground = true)
@Composable
fun PaymentScreenPreview(){

    PaymentScreen(rememberNavController())

}