package com.example.actividad.views.tab_2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun lowestGradesView(innerPaddingValues: PaddingValues, navController: NavController){
    Column(
        modifier = Modifier
            .padding(innerPaddingValues)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("sjtajaje chamacos mensos")

        Button( onClick = { navController.popBackStack() } ) {
            Text("Regresar")
        }
    }
}