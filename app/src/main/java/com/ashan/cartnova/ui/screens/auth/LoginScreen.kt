package com.ashan.cartnova.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ashan.cartnova.R
import com.ashan.cartnova.navigation.ROUTE_HOME
import com.ashan.cartnova.navigation.ROUTE_REGISTER
import com.ashan.cartnova.ui.theme.Pink20
import com.ashan.cartnova.ui.theme.Pink40

@Composable
fun LoginScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(painter = painterResource(R.drawable.bg), contentScale = ContentScale.FillBounds),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(R.drawable.img_1),
            contentDescription = "product",
            modifier = Modifier.size(300.dp).clip(shape = RoundedCornerShape(20.dp))

        )

        Text(
            text = "Login! Welcome:)",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        //Variables


        var email by remember { mutableStateOf("") }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it},
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
            placeholder = { Text(text = "example@gmail.com") },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Pink40,
                focusedBorderColor = Pink20,
                focusedLeadingIconColor = Pink20
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        var password by remember { mutableStateOf("") }

        OutlinedTextField(
            value = password,
            onValueChange = { password = it},
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
            label = { Text(text = "Password") },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Pink40,
                focusedBorderColor = Pink20,
                focusedLeadingIconColor = Pink20
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {navController.navigate(ROUTE_HOME) },
            colors = ButtonDefaults.buttonColors(Pink40),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(150.dp),
        ) {
            Text(text = "Log In")
        }

        Spacer(modifier = Modifier.height(20.dp))

        TextButton(onClick = {navController.navigate(ROUTE_REGISTER)}) {
            Text(text = "Don't have an account? Register!")
        }

        Spacer(modifier = Modifier.height(20.dp))

        TextButton(onClick = {navController.navigate(ROUTE_HOME)}) {
            Text(text = "Go To Home")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){

    LoginScreen(rememberNavController())

}