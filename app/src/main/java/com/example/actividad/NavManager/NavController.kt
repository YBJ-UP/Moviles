package com.example.actividad.NavManager

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.actividad.NavManager.routes.ROUTES
import com.example.actividad.NavManager.routes.TabROUTES
import com.example.actividad.views.tab_1.newStudentView
import com.example.actividad.views.tab_1.studentManagerView
import com.example.actividad.views.tab_2.averageGrades

@Composable
fun navController(innerPaddingValues: PaddingValues, NavController: NavHostController, startingRoute: TabROUTES){
    NavHost(
        navController = NavController,
        startDestination = startingRoute.name
    ){
         composable(ROUTES.studentManager){
            studentManagerView(innerPaddingValues, NavController)
        }
        composable(ROUTES.newStudent) {
            newStudentView(innerPaddingValues, NavController)
        }

        composable(ROUTES.averageGrades) {
            averageGrades(innerPaddingValues, NavController)
        }
    }

}