package com.example.actividad.views.tab_1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.actividad.studentDataBase.model.Student
import com.example.actividad.viewModels.StudentViewModel.StudentListViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun newStudentView(
    innerPaddingValues: PaddingValues,
    navController: NavController,
    id: Long = 0,
    viewModel: StudentListViewModel = hiltViewModel()
) {

    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var grado by remember { mutableStateOf("") }
    var grupo by remember { mutableStateOf("") }
    var puntaje by remember { mutableStateOf("") }

    var isError by remember { mutableStateOf(false) }

    val title = if (id == 0L) "Nuevo Alumno" else "Editar Alumno"
    val buttonText = if (id == 0L) "Guardar Alumno" else "Actualizar Alumno"

    LaunchedEffect(id) {
        if (id != 0L) {
            viewModel.getStudentById(id).collectLatest { student ->
                nombre = student.nombre
                apellidos = student.apellidos
                grado = student.grado.toString()
                grupo = student.grupo.toString()
                puntaje = student.puntaje.toString()
            }
        }
    }

    Column(
        modifier = Modifier
            .padding(innerPaddingValues)
            .fillMaxSize()
            .padding(30.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        StudentTextField(value = nombre, onValueChange = { nombre = it }, label = "Nombre(s)")
        StudentTextField(value = apellidos, onValueChange = { apellidos = it }, label = "Apellidos")

        StudentTextField(
            value = grado,
            onValueChange = { if (it.all { char -> char.isDigit() }) grado = it },
            label = "Grado",
            keyboardType = KeyboardType.Number
        )

        StudentTextField(
            value = grupo,
            onValueChange = { if (it.length <= 1) grupo = it.uppercase() },
            label = "Grupo",
            keyboardType = KeyboardType.Text
        )

        StudentTextField(
            value = puntaje,
            onValueChange = { if (it.all { char -> char.isDigit() }) puntaje = it },
            label = "Puntaje",
            keyboardType = KeyboardType.Number
        )

        if (isError) {
            Text(
                text = "Por favor, verifica los datos.",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (nombre.isNotBlank() && apellidos.isNotBlank() &&
                    grado.isNotBlank() && grupo.isNotBlank() && puntaje.isNotBlank()) {

                    try {
                        val studentToSave = Student(
                            id = id,
                            nombre = nombre,
                            apellidos = apellidos,
                            grado = grado.toInt(),
                            grupo = grupo.first(),
                            puntaje = puntaje.toDouble()
                        )

                        if (id == 0L) {
                            viewModel.addStudent(studentToSave)
                        } else {
                            viewModel.updateStudent(studentToSave)
                        }

                        navController.popBackStack()
                    } catch (e: Exception) {
                        isError = true
                    }
                } else {
                    isError = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(buttonText)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Text("Cancelar")
        }
    }
}
@Composable
fun StudentTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}