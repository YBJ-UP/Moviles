package com.example.actividad.studentDataBase.di

import android.app.Application
import androidx.room.Room
import com.example.actividad.studentDataBase.room.StudentDAO
import com.example.actividad.studentDataBase.room.dataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideDataBase(app: Application): dataBase{
        return Room.databaseBuilder(
            app,
            dataBase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideDataBaseDao(db: dataBase): StudentDAO {
        return db.getDAO()
    }
}