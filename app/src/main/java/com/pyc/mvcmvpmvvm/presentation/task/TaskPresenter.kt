package com.pyc.mvcmvpmvvm.presentation.task

import androidx.lifecycle.*
import com.pyc.mvcmvpmvvm.data.datasource.task.Task
import com.pyc.mvcmvpmvvm.data.repo.TaskRepository
import com.pyc.mvcmvpmvvm.presentation.contract.TaskContract
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class TaskPresenter @AssistedInject constructor(
    @Assisted private val view: TaskContract.View,
    private val repository: TaskRepository
): TaskContract.Presenter, ViewModel() {

    init {
        fetchAllTasks()
    }

    private fun fetchAllTasks() {
        viewModelScope.launch {
            repository.getAllTasks()
                .onSuccess {
                    it.collect { list ->
                        view.setTaskList(list)
                    }
                }
        }
    }

    override fun addTask() {
        viewModelScope.launch {
            repository.insertTask(Task("작업.... ${System.currentTimeMillis()}"))
        }
    }

    @AssistedFactory
    interface ViewAssistedFactory {
        fun create(view: TaskContract.View): TaskPresenter
    }

    companion object {
        fun provideFactory(
            assistedFactory: ViewAssistedFactory,
            view: TaskContract.View
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(view) as T
            }
        }
    }
}