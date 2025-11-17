package com.example.actividad.studentDataBase.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.actividad.studentDataBase.model.Student
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDAO {

    @Query("SELECT * FROM estudiantes")
    fun getAllStudents(): Flow<List<Student>>

    @Query("SELECT promedio FROM estudiantes")
    fun getAllGrades(): Flow<List<Float>>

    @Query("SELECT * FROM estudiantes WHERE grupo = :grupo")
    fun getByGroup(grupo: Char): Flow<List<Student>>

    @Query("SELECT * FROM estudiantes WHERE id = :id")
    fun getStudentById(id: Long): Flow<Student>

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun updateStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)
}