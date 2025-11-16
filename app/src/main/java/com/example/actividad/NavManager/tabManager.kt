package com.example.actividad.NavManager

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.actividad.NavManager.routes.TabROUTES

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun tab(innerPaddingValues: PaddingValues){
    val navController = rememberNavController()
    val startingRoute = TabROUTES.Estudiantes
    var selectedRoute by rememberSaveable { mutableIntStateOf(startingRoute.ordinal) }

    Scaffold(modifier = Modifier.padding(innerPaddingValues)) { contentPadding ->
        PrimaryTabRow(selectedTabIndex = selectedRoute) {
            TabROUTES.entries.forEachIndexed { index, route ->
                Tab(selected = selectedRoute == index,
                    onClick = {
                        navController.navigate(route.name)
                        selectedRoute = index
                    },
                    text = {
                        Text(route.name,
                            maxLines = 2
                        )
                    }
                )
            }
        }
        navController(contentPadding,navController, startingRoute)
    }
}