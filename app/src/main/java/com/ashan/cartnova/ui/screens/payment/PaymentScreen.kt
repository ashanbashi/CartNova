package com.ashan.cartnova.ui.screens.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(navController: NavController) {

    val CoralPink = Color(0xFFE79A94)
    val SoftBlue = Color(0xFF9FB7BE)
    val PureWhite = Color(0xFFFFFFFF)
    val TextDark = Color(0xFF1A1A1A)

    var selectedMethod by remember { mutableStateOf("M-Pesa") }
    var amount by remember { mutableStateOf("1500") }

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
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Checkout",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = PureWhite
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                colors = CardDefaults.cardColors(containerColor = PureWhite),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(modifier = Modifier.padding(16.dp)) {

                    Text("Amount", fontWeight = FontWeight.Bold, color = TextDark)

                    OutlinedTextField(
                        value = amount,
                        onValueChange = { amount = it },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text("Payment Method", fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(10.dp))

                    PaymentOption("M-Pesa", selectedMethod) { selectedMethod = it }
                    PaymentOption("Card", selectedMethod) { selectedMethod = it }
                    PaymentOption("PayPal", selectedMethod) { selectedMethod = it }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            // simulate success
                            navController.popBackStack()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = CoralPink),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(Icons.Default.CheckCircle, null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Pay Now", color = PureWhite)
                    }
                }
            }
        }
    }
}

@Composable
fun PaymentOption(label: String, selected: String, onSelect: (String) -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .background(
                if (selected == label) Color(0x22E79A94) else Color.Transparent,
                RoundedCornerShape(10.dp)
            )
            .padding(10.dp)
            .clickable { onSelect(label) },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label)
        if (selected == label) {
            Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFFE79A94))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PaymentScreenPreview(){

    PaymentScreen(rememberNavController())

}