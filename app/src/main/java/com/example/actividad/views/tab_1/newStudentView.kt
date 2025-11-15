package com.example.actividad.views.tab_1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun newStudentView(innerPaddingValues: PaddingValues, navController: NavController){
    Column(modifier = Modifier.padding(innerPaddingValues)) {
        Text("Holaaaasdbs<jfbsdbh")

        Button( onClick = {} ) {
            Text("Añadir estudiante (no hace nd)")
        }

        Button( onClick = { navController.popBackStack() } ) {
            Text("Cancelar")
        }
    }
}