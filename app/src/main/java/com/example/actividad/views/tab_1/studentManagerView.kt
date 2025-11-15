package com.example.actividad.views.tab_1

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
import com.example.actividad.NavManager.routes.ROUTES

@Composable
fun studentManagerView(innerPaddingValues: PaddingValues, navController: NavController){
    Column(
        modifier = Modifier
            .padding(innerPaddingValues)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("ts works gng so tuff")

        Button( onClick = { navController.navigate(ROUTES.newStudent) } ) {
            Text("Añadir chamaco")
        }
    }
}