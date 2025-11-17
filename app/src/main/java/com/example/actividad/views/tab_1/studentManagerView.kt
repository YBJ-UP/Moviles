package com.example.actividad.views.tab_1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.actividad.NavManager.routes.ROUTES
import com.example.actividad.studentDataBase.model.Student


fun getSampleStudents(): List<Student> {
    return listOf(

        Student(1, "Ana", "García Pérez", 1, 'A', 8.0),
        Student(2, "Luis", "Martínez López", 3, 'B', 8.0),
        Student(3, "Sofía", "Ramírez Torres", 2, 'C', 7.0),
        Student(4, "Carlos", "Hernández Diaz", 1, 'A', 9.0),
        Student(5, "Elena", "Vázquez Ruiz", 3, 'A', 8.0),
        Student(6, "Jorge", "Sánchez Cano", 4, 'D', 7.0),
    )
}

@Composable
fun studentManagerView(innerPaddingValues: PaddingValues, navController: NavController) {
    val studentList = getSampleStudents()

    Column(
        modifier = Modifier
            .padding(innerPaddingValues)
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(
            onClick = { navController.navigate(ROUTES.newStudent) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Agregar Alumno",
                modifier = Modifier.padding(end = 4.dp)
            )
            Text("Agregar Nuevo Alumno")
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(studentList) { student ->
                StudentCard(student = student)
            }
        }
    }
}


@Composable
fun StudentCard(student: Student) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Nombre Completo
                Text(
                    text = "${student.nombre} ${student.apellidos}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                // ID
                Text(
                    text = "ID: ${student.id}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DataLabel(label = "Grado", value = student.grado.toString())
                DataLabel(label = "Grupo", value = student.grupo.toString())
                DataLabel(label = "Puntaje", value = student.puntaje.toString())
            }
        }
    }
}


@Composable
fun DataLabel(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Light,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )
    }
}