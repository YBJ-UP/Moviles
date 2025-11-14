package com.example.actividad.NavMnager

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun Navcontroll(){
 val NavController = rememberNavController()
 NavHost(
  navController = NavController,
  startDestination = ""
 ){}

}