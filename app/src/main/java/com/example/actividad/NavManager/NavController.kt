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
import com.example.actividad.views.tab_2.lowestGradesView
import com.example.actividad.views.tab_2.topThreeView

@Composable
fun navController(innerPaddingValues: PaddingValues, NavController: NavHostController, startingRoute: TabROUTES){
    NavHost(
        navController = NavController,
        startDestination = startingRoute.name
    ){
        //tab 1
         composable(ROUTES.studentManager){
            studentManagerView(innerPaddingValues, NavController)
        }
        composable(ROUTES.newStudent) {
            newStudentView(innerPaddingValues, NavController)
        }

        //tab 2
        composable(ROUTES.averageGrades) {
            averageGrades(innerPaddingValues, NavController)
        }
        composable(ROUTES.topThreePerGroup){
            topThreeView(innerPaddingValues, NavController)
        }
    }

}