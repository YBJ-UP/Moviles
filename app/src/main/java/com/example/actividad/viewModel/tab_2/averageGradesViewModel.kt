package com.example.actividad.viewModel.tab_2

import androidx.lifecycle.ViewModel
import com.example.actividad.studentDataBase.model.Student
import com.example.actividad.studentDataBase.repository.studentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class averageGradesViewModel @Inject constructor(private val repository: studentRepository): ViewModel() {

    val allGrades: Flow<List<Float>> = repository.getAllGrades()

    val averageGrade: Flow<Float> = allGrades.map { grades ->
        if (!grades.isEmpty()){
            grades.sum() / grades.size
        } else {
            0f
        }
    }

    val lowestGrades: Flow<List<Student>> = repository.getLowestGrades()
}