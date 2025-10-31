package com.example.a23012011072_mad_prac5.screen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.a23012011072_mad_prac5.R
import com.example.a23012011072_mad_prac5.screen.components.FormField
import com.example.a23012011072_mad_prac5.ui.theme.Pink80

@Composable
fun RegisterScreen(context: Context, navController: NavController){
    Scaffold (modifier = Modifier.fillMaxSize()){
            innerPadding->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)){
            RegisterUI(navController=navController)
        }
    }
}

@Composable
fun RegisterUI(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("@gmail.com") }
    var password by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Image(
            painter = painterResource(R.drawable.guni_pink_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .height(130.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )

        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {

                // --- Name ---
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Name",
                        fontSize = 12.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Box(modifier = Modifier.weight(2f)) {
                        FormField("Name", name, { name = it })
                    }
                }

                // --- Phone ---
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Phone Number",
                        fontSize = 12.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Box(modifier = Modifier.weight(2f)) {
                        FormField("Phone Number", phone, { phone = it }, isNumber = true)
                    }
                }

                // --- City ---
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "City",
                        fontSize = 12.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Box(modifier = Modifier.weight(2f)) {
                        FormField("City", city, { city = it })
                    }
                }

                // --- Email ---
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Email",
                        fontSize = 12.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Box(modifier = Modifier.weight(2f)) {
                        FormField("Email", email, { email = it })
                    }
                }

                // --- Password ---
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Password",
                        fontSize = 12.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Box(modifier = Modifier.weight(2f)) {
                        FormField("Password", password, { password = it }, isPasswordField = true)
                    }
                }

                // --- Confirm Password ---
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Confirm Password",
                        fontSize = 12.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Box(modifier = Modifier.weight(2f)) {
                        FormField("Confirm Password", confirm, { confirm = it }, isPasswordField = true)
                    }
                }

                // --- Register Button ---
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text("Register", fontSize = 18.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // --- Navigation to Login ---
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Do you have an account?", fontSize = 14.sp)
            Spacer(modifier = Modifier.width(5.dp))
            TextButton(onClick = {
                if(navController!=null)
                    navigatetoregistrationScreen(navController)
            }) {
                Text("LOGIN", color = Pink80, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    val navController = rememberNavController()
    RegisterUI(navController)
}