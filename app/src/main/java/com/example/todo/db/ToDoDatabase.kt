package com.example.todo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo.model.ToDo


@Database(entities = [ToDo::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun getDao() : ToDoDao
}