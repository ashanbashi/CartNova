package com.ashan.cartnova.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashan.cartnova.R
import com.ashan.cartnova.ui.theme.Pink20

@Composable
fun OnBoardingScreen1(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(R.drawable.product),
            contentDescription = "product",
            modifier = Modifier.size(300.dp)

        )


        Spacer(modifier = Modifier.height(20.dp))


        Text(
            text = "Welcome To CartNova",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Cursive,
            color = Pink20
        )


        Spacer(modifier = Modifier.height(20.dp))


        Text(
            text = "The world is full of small, unnoticed moments that often carry the most meaning. A quiet sunrise, a kind word from a stranger, or the feeling of accomplishment after finishing a simple task can shape our days more than we realize. By slowing down and paying attention, we begin to appreciate these subtle experiences, finding joy not in grand events but in the gentle rhythm of everyday life.",
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Cursive,

        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(Pink20),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(350.dp)
        ) {
            Text(text = "Get Started")
        }













    }
}


@Preview(showBackground = true)
@Composable
fun OnBoardingScreen1Preview(){

    OnBoardingScreen1()

}