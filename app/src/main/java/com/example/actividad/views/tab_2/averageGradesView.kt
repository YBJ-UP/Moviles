package com.example.actividad.views.tab_2

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.actividad.NavManager.routes.ROUTES
import com.example.actividad.viewModel.tab_2.averageGradesViewModel

@Composable
fun averageGrades(
    innerPaddingValues: PaddingValues,
    navController: NavController,
    viewModel: averageGradesViewModel = hiltViewModel()
){
    val avgGrade: Float = viewModel.averageGrade.collectAsState(initial = 0f).value

    Column(
        modifier = Modifier
            .padding(innerPaddingValues)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Card {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                if (avgGrade > 0f){
                    Text("La calificación promedio de los alumnos es:")
                    Text(
                        text = "${avgGrade}",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge
                    )
                } else {
                    Text("No hay alumnos guardados.")
                    Text(
                        text = "Para ver la calificación promedio, añada al menos un alumno.",
                        textAlign = TextAlign.Center
                    )
                }
            }

        }


        Spacer(modifier = Modifier.height(20.dp))

        Text("Acá van los q tienen más resago")

        Button( onClick = { navController.navigate(ROUTES.topThreePerGroup) } ) {
            Text("Alumnos con calificación más alta")
        }
    }
}