package com.ashan.cartnova.ui.screens.splash


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ashan.cartnova.R
import com.ashan.cartnova.navigation.ROUTE_ONBOARD1
import com.ashan.cartnova.ui.theme.Pink40
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController){
    //Navigation
    val x = rememberCoroutineScope ()
    x.launch {
        delay(3000)
        navController.navigate(ROUTE_ONBOARD1)
    }
    //End of Navigation
    Column(
        modifier = Modifier.fillMaxSize().background(Pink40),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Image(
            painter = painterResource(R.drawable.cartnova),
            contentDescription = "product",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "CartNova",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold,
        )

    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){

    SplashScreen(rememberNavController())

}