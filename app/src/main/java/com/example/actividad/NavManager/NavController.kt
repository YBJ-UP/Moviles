package com.example.actividad.NavManager

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.actividad.views.tab_1.newStudentView
import com.example.actividad.views.tab_1.studentManagerView

@Composable
fun navController(innerPaddingValues: PaddingValues, NavController: NavHostController, startingRoute: ROUTES){
    NavHost(
        navController = NavController,
        startDestination = startingRoute.name
    ){
         composable(ROUTES.studentManager.name){
            studentManagerView(innerPaddingValues, NavController)
        }
        composable(ROUTES.newStudent.name) {
            newStudentView(innerPaddingValues, NavController)
        }
    }

}