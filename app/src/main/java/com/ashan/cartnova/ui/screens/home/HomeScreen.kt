package com.ashan.cartnova.ui.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ashan.cartnova.R
import com.ashan.cartnova.navigation.ROUTE_INTENT
import com.ashan.cartnova.navigation.ROUTE_CART
import com.ashan.cartnova.navigation.ROUTE_DASHBOARD
import com.ashan.cartnova.navigation.ROUTE_PRODUCT

// 🎨 COLORS
val CoralPink = Color(0xFFE79A94)
val SoftBlue = Color(0xFF9FB7BE)
val PureWhite = Color(0xFFFFFFFF)
val TextDark = Color(0xFF1A1A1A)

// ---------------- SCREEN ----------------
@Composable
fun HomeScreen(navController: NavController) {
    ModernHome(navController)
}

// ---------------- UI ----------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModernHome(navController: NavController) {

    Scaffold(

        containerColor = Color.Transparent,

        topBar = {
            TopAppBar(
                title = {
                    Text("CartNova", color = PureWhite)
                },

                navigationIcon = {
                    IconButton(onClick = {
                        // optional: you can later control drawer state here
                        navController.navigate(ROUTE_DASHBOARD)
                    }) {
                        Icon(Icons.Default.Menu, null, tint = PureWhite)
                    }
                },

                actions = {

                    // 🛒 CART ICON FIXED
                    IconButton(onClick = {
                        navController.navigate(ROUTE_CART)
                    }) {
                        Icon(
                            Icons.Default.ShoppingCart,
                            contentDescription = "Cart",
                            tint = PureWhite
                        )
                    }

                    // 🔔 EXTRA ICON (optional)
                    IconButton(onClick = {
                        navController.navigate(ROUTE_INTENT)
                    }) {
                        Icon(Icons.Default.Notifications, null, tint = PureWhite)
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = CoralPink
                )
            )
        }

    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(CoralPink, SoftBlue)
                    )
                )
                .padding(padding)
        ) {

            // 🖼 HERO BANNER
            item {
                Image(
                    painter = painterResource(R.drawable.obs_1),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            // 🔥 TITLE
            item {
                Text(
                    "Trending Now",
                    color = PureWhite,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }

            // 🧩 PRODUCT LIST
            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(10) { index ->
                        ModernProductCard(
                            name = "Item $index",
                            price = "Ksh ${(index + 1) * 1500}",
                            image = R.drawable.grocery1,
                            onClick = {
                                navController.navigate(ROUTE_PRODUCT)
                            }
                        )
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(20.dp)) }
        }
    }
}

// ---------------- PRODUCT CARD ----------------
@Composable
fun ModernProductCard(
    name: String,
    price: String,
    image: Int,
    onClick: () -> Unit
) {

    var liked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.width(180.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = PureWhite)
    ) {

        Column {

            Box {

                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                    contentScale = ContentScale.Crop
                )

                IconButton(
                    onClick = { liked = !liked },
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = null,
                        tint = if (liked) CoralPink else Color.LightGray
                    )
                }
            }

            Column(modifier = Modifier.padding(10.dp)) {

                Text(name, color = TextDark, fontWeight = FontWeight.Bold)
                Text(price, color = TextDark.copy(alpha = 0.7f))

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(containerColor = CoralPink),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text("Buy", color = PureWhite)
                }
            }
        }
    }
}

// ---------------- PREVIEW ----------------
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen(rememberNavController())
}