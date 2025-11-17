package com.example.actividad.studentDataBase.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.actividad.studentDataBase.model.Student

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class dataBase: RoomDatabase() {
    abstract fun getDAO(): StudentDAO
}