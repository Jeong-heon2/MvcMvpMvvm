package com.pyc.mvcmvpmvvm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pyc.mvcmvpmvvm.data.datasource.task.Task
import com.pyc.mvcmvpmvvm.data.repo.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    private var _liveTaskList = MutableLiveData<List<Task>>(emptyList())
    val liveTaskList: LiveData<List<Task>> get() = _liveTaskList

    init {
        fetchAllTasks()
    }

    fun fetchAllTasks() {
        viewModelScope.launch {
            repository.getAllTasks()
                .onSuccess {
                    it.collect { list ->
                        _liveTaskList.value = list
                    }
                }
        }
    }

    fun insertTask() {
        viewModelScope.launch {
            repository.insertTask(Task("작업.... ${System.currentTimeMillis()}"))
                .onSuccess { /* do something..*/ }
        }
    }
}