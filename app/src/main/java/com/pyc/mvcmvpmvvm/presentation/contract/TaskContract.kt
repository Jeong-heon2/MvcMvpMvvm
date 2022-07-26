package com.pyc.mvcmvpmvvm.presentation.contract

import com.pyc.mvcmvpmvvm.data.datasource.task.Task

interface TaskContract {

    interface View {

        fun setTaskList(tasks: List<Task>)
    }

    interface Presenter {

        fun addTask()
    }
}