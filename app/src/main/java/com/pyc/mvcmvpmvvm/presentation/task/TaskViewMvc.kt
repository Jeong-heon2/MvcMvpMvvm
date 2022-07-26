package com.pyc.mvcmvpmvvm.presentation.task

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.pyc.mvcmvpmvvm.R
import com.pyc.mvcmvpmvvm.data.datasource.task.Task
import com.pyc.mvcmvpmvvm.presentation.adapter.TaskAdapter
import com.pyc.mvcmvpmvvm.presentation.common.view.BaseObservableViewMvc
import com.pyc.mvcmvpmvvm.presentation.common.view.BaseViewMvc

class TaskViewMvc(
    inflater: LayoutInflater,
    parent: ViewGroup?,
) : BaseObservableViewMvc<TaskViewMvc.Listener>() {

    private val taskRecyclerView: RecyclerView
    private val addButton: Button
    private val adapter: TaskAdapter

    init {
        setRootView(inflater.inflate(R.layout.activity_main, parent, false))
        taskRecyclerView = findViewById(R.id.recyclerViewTask)
        adapter = TaskAdapter()
        taskRecyclerView.adapter = adapter
        addButton = findViewById(R.id.buttonAddTask)

        addButton.setOnClickListener {
            listeners.forEach { l ->
                l.onAddTaskClicked()
            }
        }
    }

    fun bindTasks(tasks: List<Task>) {
        adapter.submitList(tasks)
    }

    interface Listener {
        fun onAddTaskClicked()
    }
}