package com.pyc.mvcmvpmvvm.data.repo

import com.pyc.mvcmvpmvvm.data.datasource.task.Task
import com.pyc.mvcmvpmvvm.data.datasource.task.TaskDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val taskDataSource: TaskDataSource
) : TaskRepository {

    override suspend fun getAllTasks(): Result<Flow<List<Task>>> =
        taskDataSource.getAllTasks()

    override suspend fun insertTask(task: Task): Result<Unit> =
        taskDataSource.insertTask(task)
}