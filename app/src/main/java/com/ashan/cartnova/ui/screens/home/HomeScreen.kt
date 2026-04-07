package com.ashan.cartnova.ui.screens.home

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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.ashan.cartnova.ui.theme.Pink20


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        //TopAppBar

        TopAppBar(
            title = {Text(text = "Home")},
            navigationIcon = {
                IconButton(onClick = {}){
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "menu" )
                } },

            actions = {
                IconButton(onClick = {}){
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "cart" )
                }

                IconButton(onClick = {}){
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = "" )
                }
            },

            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = _root_ide_package_.com.ashan.cartnova.ui.theme.Pink40,
                navigationIconContentColor = Color.White,
                actionIconContentColor = Color.White,
                titleContentColor = Color.White,
            )

        )


        //End Of TopAppBar





    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){

    HomeScreen()

}