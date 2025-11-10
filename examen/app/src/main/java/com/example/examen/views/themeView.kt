package com.example.examen.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.examen.viewModel.themeViewModel.ThemeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun themeView(navController: NavController, themeViewModel: ThemeViewModel){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Cambiar tema de la app") },
                navigationIcon = {
                    IconButton( onClick = { navController.popBackStack() } ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar")
                    }
                }
            )
        }
    ) { themeContent(it, navController, themeViewModel) }
}

@Composable
fun themeContent(innerPaddingValues: PaddingValues, navController: NavController, themeViewModel: ThemeViewModel){
    val isDarkTheme by themeViewModel.getTheme.collectAsState(false)
    Column(
        modifier = Modifier
            .padding(innerPaddingValues)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Switch(
            checked = isDarkTheme,
            onCheckedChange = {
                newCheckedState ->
                    themeViewModel.saveTheme(newCheckedState)
            }
        )
        Text(
            if (isDarkTheme) { "Modo oscuro activado" }
            else { "Modo claro activado" }
        )
    }


}