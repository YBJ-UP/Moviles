package com.example.actividad.viewModels.StudentViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.actividad.studentDataBase.model.Student
import com.example.actividad.studentDataBase.repository.studentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class StudentList(
    val students: List<Student> = emptyList(),
    val isLoading: Boolean = true
)

@HiltViewModel
class StudentListViewModel @Inject constructor(private val repository: studentRepository): ViewModel(){
    val state: StateFlow<StudentList> = repository.getAll()
        .map{students ->
            StudentList(
                students = students,
                isLoading = false
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = StudentList()
        )

    fun addStudent(student: Student) {
        viewModelScope.launch {
            repository.addStudent(student)
        }
    }

    fun deleteStudent(student: Student) {
        viewModelScope.launch {
            repository.deleteStudent(student)
        }
    }
}