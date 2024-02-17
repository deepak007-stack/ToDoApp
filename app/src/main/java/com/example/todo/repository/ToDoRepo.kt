package com.example.todo.repository

import com.example.todo.db.ToDoDao
import com.example.todo.model.ToDo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ToDoRepo
@Inject constructor(private val dao: ToDoDao){

    suspend fun insert(toDo: ToDo){
        withContext(Dispatchers.IO){
            dao.insertData(toDo)
        }
    }

    fun getData() : Flow<List<ToDo>>{
        return dao.getData()
    }
}