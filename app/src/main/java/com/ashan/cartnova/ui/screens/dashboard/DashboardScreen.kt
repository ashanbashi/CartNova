package com.ashan.cartnova.ui.screens.dashboard

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ashan.cartnova.R
import com.ashan.cartnova.navigation.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {

    val CoralPink = Color(0xFFE79A94)
    val SoftBlue = Color(0xFF9FB7BE)
    val PureWhite = Color(0xFFFFFFFF)
    val TextDark = Color(0xFF1A1A1A)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(CoralPink, SoftBlue))
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {

            // 🔥 HEADER
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Hello 👋", color = PureWhite.copy(alpha = 0.9f))
                    Text(
                        "Welcome to CartNova",
                        color = PureWhite,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }

                IconButton(
                    onClick = { navController.navigate(ROUTE_INTENT) }
                ) {
                    Icon(Icons.Default.Notifications, null, tint = PureWhite)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 📊 STATS CARDS
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StatCard("Orders", "24")
                StatCard("Cart", "5")
                StatCard("Wishlist", "12")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 🔍 SEARCH BAR
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Search products...") },
                leadingIcon = { Icon(Icons.Default.Search, null) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = PureWhite,
                    unfocusedContainerColor = PureWhite
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 🧩 QUICK ACTIONS
            Text("Quick Actions", color = PureWhite, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(10.dp))

            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                ActionButton("Shop", Icons.Default.ShoppingCart) {
                    navController.navigate(ROUTE_HOME)
                }

                ActionButton("Payment", Icons.Default.AccountBox) {
                    navController.navigate(ROUTE_PAYMENT)
                }

                ActionButton("Profile", Icons.Default.Person) {
                    navController.navigate(ROUTE_LOGIN)
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            // 🛍 FEATURED PRODUCTS
            Text("Featured Products", color = PureWhite, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(10.dp))

            repeat(5) { index ->
                FeaturedProductCard(
                    name = "Product $index",
                    price = "Ksh ${(index + 1) * 1200}",
                    onClick = { navController.navigate(ROUTE_HOME) }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
fun StatCard(title: String, value: String) {

    Card(
        modifier = Modifier
            .width(100.dp)
            .height(80.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(value, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(title, fontSize = 12.sp)
        }
    }
}

@Composable
fun ActionButton(text: String, icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .clickable { onClick() }
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(icon, contentDescription = null, tint = Color(0xFFE79A94))
        Text(text, fontSize = 12.sp)
    }
}

@Composable
fun FeaturedProductCard(name: String, price: String, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(name, fontWeight = FontWeight.Bold)
                Text(price, color = Color.Gray)
            }

            Icon(Icons.Default.ArrowForward, contentDescription = null)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(navController = rememberNavController())
}