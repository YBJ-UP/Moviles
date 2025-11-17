package com.example.actividad.studentDataBase.repository

import com.example.actividad.studentDataBase.model.Student
import com.example.actividad.studentDataBase.room.StudentDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class studentRepository @Inject constructor(private val dao: StudentDAO) {
    fun getAll(): Flow<List<Student>> = dao.getAllStudents().flowOn(Dispatchers.IO).conflate()
    fun getAllGrades(): Flow<List<Float>> = dao.getAllGrades().flowOn(Dispatchers.IO).conflate()
    fun getByGroup(group: Char): Flow<List<Student>> = dao.getByGroup(group).flowOn(Dispatchers.IO).conflate()
    fun getById(id: Long): Flow<Student> = dao.getStudentById(id).flowOn(Dispatchers.IO).conflate()
    suspend fun addStudent(student: Student) = dao.addStudent(student)
    suspend fun updateStudent(student: Student) = dao.updateStudent(student)
    suspend fun deleteStudent(student: Student) = dao.deleteStudent(student)
}