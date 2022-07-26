package com.pyc.mvcmvpmvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.pyc.mvcmvpmvvm.R
import com.pyc.mvcmvpmvvm.data.datasource.task.Task
import com.pyc.mvcmvpmvvm.data.repo.TaskRepository
import com.pyc.mvcmvpmvvm.presentation.task.TaskViewMvc
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), TaskViewMvc.Listener {

    private val taskViewMvc: TaskViewMvc by lazy {
        TaskViewMvc(layoutInflater, null)
    }

    @Inject
    lateinit var repository: TaskRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        taskViewMvc.registerListener(this)
        setContentView(taskViewMvc.getRootView())
        fetchAllTasks()
    }

    private fun fetchAllTasks() {
        lifecycleScope.launchWhenResumed {
            repository.getAllTasks()
                .onSuccess {
                    it.collect { list ->
                        taskViewMvc.bindTasks(list)
                    }
                }
        }
    }

    override fun onAddTaskClicked() {
        lifecycleScope.launchWhenResumed {
            repository.insertTask(Task("작업.... ${System.currentTimeMillis()}"))
        }
    }
}