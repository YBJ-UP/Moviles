package com.example.actividad.viewModel.tab_2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.actividad.studentDataBase.model.Student
import com.example.actividad.studentDataBase.repository.studentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class highestGradesViewModel @Inject constructor(private val repository: studentRepository): ViewModel() {
    val grades: StateFlow<Map<Char, List<Student>>> =
        repository.getTopThreePerGroup()
            .map { lista -> lista.groupBy { it.grupo } }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyMap()
            )
    val hola = "hola"
}