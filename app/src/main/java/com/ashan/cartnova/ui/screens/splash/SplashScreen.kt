package com.ashan.cartnova.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ashan.cartnova.R
import com.ashan.cartnova.navigation.ROUTE_ONBOARD1
import kotlinx.coroutines.delay

// 🎨 CARTNOVA COLORS
val CoralPink = Color(0xFFE79A94)
val SoftBlue = Color(0xFF9FB7BE)
val PureWhite = Color(0xFFFFFFFF)

@Composable
fun SplashScreen(navController: NavController) {

    // ✅ Proper lifecycle-safe navigation
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(ROUTE_ONBOARD1) {
            popUpTo(0) // clears splash from back stack
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    colors = listOf(
                        CoralPink,
                        SoftBlue,
                        Color.Black
                    ),
                    radius = 1200f
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // 🔥 Logo with glow effect
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .clip(CircleShape)
                    .background(PureWhite.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.cartnova),
                    contentDescription = "logo",
                    modifier = Modifier.size(100.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "CartNova",
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                color = PureWhite
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Shop Smart. Live Better.",
                fontSize = 14.sp,
                color = PureWhite.copy(alpha = 0.7f)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){

    SplashScreen(rememberNavController())

}