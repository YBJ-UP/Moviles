package com.example.actividad.NavManager

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.actividad.views.tab_1.newStudentView
import com.example.actividad.views.tab_1.studentManagerView

@Composable
fun navController(innerPaddingValues: PaddingValues){

    val NavController = rememberNavController()
    NavHost(
        navController = NavController,
        startDestination = ROUTES.studentManager
    ){
         composable(ROUTES.studentManager){
            studentManagerView(innerPaddingValues, NavController)
        }
        composable(ROUTES.newStudent) {
            newStudentView(innerPaddingValues, NavController)
        }
    }

}