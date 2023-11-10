package com.example.wanderlust

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("SuspiciousIndentation")
@Composable
fun myapp(){
    var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val navController=rememberNavController()
    NavHost(
        navController=navController,
        startDestination="Welcome"
    ){
        composable("Welcome"){Welcome(navController)}
        composable("SignUp"){ SignUp(navController)}
        composable("Login"){ Login(navController)}
        composable("Bookmark"){ Bookmark(navController)}
        composable("ProfileScreen"){ ProfileScreen(navController)}
    }
}

class MainActivity:ComponentActivity(){
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        setContent{
            myapp()
        }
    }
}
