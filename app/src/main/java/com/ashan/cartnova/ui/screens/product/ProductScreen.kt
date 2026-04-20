package com.ashan.cartnova.ui.screens.product

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
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
import com.ashan.cartnova.navigation.ROUTE_CART

@Composable
fun ProductScreen(navController: NavController) {

    val CoralPink = Color(0xFFE79A94)
    val SoftBlue = Color(0xFF9FB7BE)
    val PureWhite = Color(0xFFFFFFFF)
    val TextDark = Color(0xFF1A1A1A)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(CoralPink, SoftBlue)))
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        // 🖼 PRODUCT IMAGE
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 📦 TITLE + PRICE
        Text(
            "Premium Sneakers",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = PureWhite
        )

        Text(
            "Ksh 3,500",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = PureWhite.copy(alpha = 0.9f)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // ⭐ RATING
        Row(verticalAlignment = Alignment.CenterVertically) {
            repeat(5) {
                Icon(Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text("4.8 (1.2k reviews)", color = PureWhite)
        }

        Spacer(modifier = Modifier.height(15.dp))

        // 📖 ABOUT PRODUCT
        Card(
            colors = CardDefaults.cardColors(containerColor = PureWhite),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(12.dp)) {

                Text("About Product", fontWeight = FontWeight.Bold, color = TextDark)

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    "These premium sneakers are designed for comfort, durability, and style. Perfect for sports, walking, and casual wear.",
                    color = TextDark
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        // 🧾 FEATURES
        Card(
            colors = CardDefaults.cardColors(containerColor = PureWhite),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(12.dp)) {

                Text("Features", fontWeight = FontWeight.Bold, color = TextDark)

                Spacer(modifier = Modifier.height(6.dp))

                listOf(
                    "Lightweight design",
                    "Breathable material",
                    "Shock absorption sole",
                    "Unisex style"
                ).forEach {
                    Text("• $it", color = TextDark)
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        // 💬 REVIEWS SECTION
        Text("Customer Reviews", fontWeight = FontWeight.Bold, color = PureWhite)

        Spacer(modifier = Modifier.height(10.dp))

        repeat(2) { index ->
            Card(
                colors = CardDefaults.cardColors(containerColor = PureWhite),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {

                    Text("User $index", fontWeight = FontWeight.Bold)

                    Row {
                        repeat(4) {
                            Icon(Icons.Default.Star, null, tint = Color.Yellow)
                        }
                    }

                    Text("Great product! Very comfortable and worth the price.")
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // 🛒 SUGGESTED PRODUCTS
        Text("Suggested For You", fontWeight = FontWeight.Bold, color = PureWhite)

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {

            repeat(2) { index ->

                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(140.dp),
                    colors = CardDefaults.cardColors(containerColor = PureWhite),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp)
                                .background(Color.LightGray)
                        )

                        Text("Product $index", fontWeight = FontWeight.Bold)
                        Text("Ksh ${(index + 1) * 1200}")

                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = CoralPink),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("View", color = PureWhite, fontSize = 12.sp)
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 🛒 BUY BUTTON
        Button(
            onClick = { navController.navigate(ROUTE_CART) },
            modifier = Modifier.fillMaxWidth().height(55.dp),
            colors = ButtonDefaults.buttonColors(containerColor = CoralPink),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Add to Cart", color = PureWhite, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductScreenPreview() {
    ProductScreen(navController = rememberNavController())
}
