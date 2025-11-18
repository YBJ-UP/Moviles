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

    @Query("""
        SELECT * FROM (
            SELECT *,
            ROW_NUMBER() OVER (
                PARTITION BY grupo
                ORDER BY promedio DESC
            ) AS n
            FROM estudiantes
        ) WHERE n <= 3
    """)
    fun getTopThreePerGroup(): Flow<List<Student>>

    @Query("SELECT * FROM estudiantes ORDER BY promedio ASC LIMIT 3")
    fun getLowestTenGrades(): Flow<List<Student>>

    @Query("SELECT * FROM estudiantes WHERE id = :id")
    fun getStudentById(id: Long): Flow<Student>

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun updateStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)
}