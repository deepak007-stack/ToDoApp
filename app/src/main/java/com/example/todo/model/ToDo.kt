package com.example.todo.model

import androidx.room.Entity

@Entity(tableName = "toDoList")
class ToDo (
    val title : String,
    val description : String
)