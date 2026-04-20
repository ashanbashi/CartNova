package com.ashan.cartnova.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ashan.cartnova.R
import com.ashan.cartnova.navigation.ROUTE_REGISTER

// 🎨 SAME HOME SCREEN COLORS
val CoralPink = Color(0xFFE79A94)
val SoftBlue = Color(0xFF9FB7BE)
val PureWhite = Color(0xFFFFFFFF)
val TextDark = Color(0xFF1A1A1A)

@Composable
fun OnBoardingScreen1(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(CoralPink, SoftBlue)
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // 🖼 IMAGE (same style as hero banner)
            Image(
                painter = painterResource(R.drawable.obs_1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(340.dp)
                    .clip(RoundedCornerShape(24.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(25.dp))

            // 🔥 TITLE (matches Home UI feel)
            Text(
                text = "Welcome to CartNova",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = PureWhite
            )

            Spacer(modifier = Modifier.height(10.dp))

            // 🧠 DESCRIPTION
            Text(
                text = "Discover trending products, shop easily, and enjoy a smooth modern shopping experience designed just for you.",
                fontSize = 16.sp,
                color = PureWhite.copy(alpha = 0.85f),
                textAlign = TextAlign.Center,
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(35.dp))

            // 🚀 BUTTON (same as product Buy button style)
            Button(
                onClick = { navController.navigate(ROUTE_REGISTER) },
                colors = ButtonDefaults.buttonColors(containerColor = PureWhite),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(
                    text = "Get Started",
                    color = CoralPink,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun OnBoardingScreen1Preview(){

    OnBoardingScreen1(rememberNavController())

}