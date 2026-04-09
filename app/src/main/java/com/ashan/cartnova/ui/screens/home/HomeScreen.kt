package com.ashan.cartnova.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashan.cartnova.R
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

        Spacer(modifier = Modifier.height(20.dp))

        //SearchBar

        var search by remember { mutableStateOf("") }

        TextField(
            value = search,
            onValueChange = { search = it},
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
            placeholder = { Text(text = "Search for products/Category...") },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") }
        )

        //End Of SearchBar

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Featured Categories",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 20.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        //Row

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {

            Column() {
                Image(
                    painter = painterResource(R.drawable.grocery1),
                    contentDescription = "grocery",
                    modifier = Modifier.size(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop,
                )

                Text(
                    text = "Groceries",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 50.dp)
                )

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(Pink20),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(start = 40.dp),
                ) {
                    Text(text = "Shop Now")
                }
            }

            Spacer(modifier = Modifier.width(20.dp))


            Column() {
                Image(
                    painter = painterResource(R.drawable.grocery1),
                    contentDescription = "grocery",
                    modifier = Modifier.size(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Groceries",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 50.dp)
                )

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(Pink20),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(start = 40.dp),
                ) {
                    Text(text = "Shop Now")
                }
            }

            Spacer(modifier = Modifier.width(20.dp))

            Column() {
                Image(
                    painter = painterResource(R.drawable.grocery1),
                    contentDescription = "grocery",
                    modifier = Modifier.size(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Groceries",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 50.dp)
                )

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(Pink20),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(start = 40.dp),
                ) {
                    Text(text = "Shop Now")
                }
            }

        }

        //End Of Row





    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){

    HomeScreen()

}