package com.example.todo.module

import android.content.Context
import androidx.room.Room
import com.example.todo.db.ToDoDao
import com.example.todo.db.ToDoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ToDoModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ToDoDatabase {

        return Room.databaseBuilder(context, ToDoDatabase::class.java, "ToDoDatabase").build()
    }

    @Provides
    @Singleton
    fun provideDAO(database : ToDoDatabase) : ToDoDao {

        return database.getDao()
    }
}