package com.example.actividad.studentDataBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "estudiantes")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "apellidos")
    val apellidos: String,
    @ColumnInfo(name = "grado")
    val grado: Int,
    @ColumnInfo(name = "grupo")
    val grupo: Char,
    @ColumnInfo(name = "promedio")
    val puntaje: Double
)
