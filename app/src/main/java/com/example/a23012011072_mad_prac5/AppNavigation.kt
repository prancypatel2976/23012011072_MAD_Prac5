package com.example.a23012011072_mad_prac5

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a23012011072_mad_prac5.screen.LoginScreen
import com.example.a23012011072_mad_prac5.screen.LoginUI
import com.example.a23012011072_mad_prac5.screen.RegisterScreen

@Composable
fun AppNavigation(context: Context){
    val navcontroller = rememberNavController()
    NavHost(navController = navcontroller,
        startDestination = "login"){
        composable("login"){
            LoginScreen(context,navcontroller)
        }
        composable("registration"){
            RegisterScreen(context,navcontroller)
        }
    }
}