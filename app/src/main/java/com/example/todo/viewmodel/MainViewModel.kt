package com.example.todo.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.model.ToDo
import com.example.todo.repository.ToDoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect


@HiltViewModel
class MainViewModel @Inject constructor(private val toDoRepo: ToDoRepo) : ViewModel() {

    val response : MutableState<List<ToDo>> = mutableStateOf(listOf())

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            toDoRepo.getData()
                .catch { e ->
                    Log.d("main","Exception : ${e.message}")
                }
                .collect{
                    response.value = it
                }
        }
    }

    fun insert(toDo: ToDo) {
        viewModelScope.launch {
            toDoRepo.insert(toDo)
        }
    }


}