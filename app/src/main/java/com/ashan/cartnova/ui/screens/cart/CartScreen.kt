package com.ashan.cartnova.ui.screens.cart

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ashan.cartnova.navigation.ROUTE_PAYMENT

@Composable
fun CartScreen(navController: NavController) {

    val CoralPink = Color(0xFFE79A94)
    val SoftBlue = Color(0xFF9FB7BE)
    val PureWhite = Color(0xFFFFFFFF)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(CoralPink, SoftBlue)))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Text(
                "Your Cart",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = PureWhite
            )

            Spacer(modifier = Modifier.height(20.dp))

            repeat(3) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    colors = CardDefaults.cardColors(containerColor = PureWhite)
                ) {

                    Row(
                        modifier = Modifier.padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("Product $it", fontWeight = FontWeight.Bold)
                            Text("Ksh ${(it + 1) * 1500}")
                        }

                        Icon(Icons.Default.Delete, contentDescription = null)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { navController.navigate(ROUTE_PAYMENT) },
                colors = ButtonDefaults.buttonColors(containerColor = CoralPink),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Proceed to Payment", color = PureWhite)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CartScreenPreview() {
    MaterialTheme {
        CartScreen(navController = rememberNavController())
    }
}
