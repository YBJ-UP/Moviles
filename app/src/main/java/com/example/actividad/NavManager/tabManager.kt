package com.example.actividad.NavManager

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun tab(){
    val navController = rememberNavController()
    val startingRoute = ROUTES.studentManager
    var selectedRoute by rememberSaveable { mutableIntStateOf(startingRoute.ordinal) }

    Scaffold(modifier = Modifier) { contentPadding ->
        PrimaryTabRow(selectedTabIndex = selectedRoute, modifier = Modifier.padding(contentPadding)) {
            ROUTES.entries.forEachIndexed { index, route ->
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