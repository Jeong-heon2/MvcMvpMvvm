package com.pyc.mvcmvpmvvm.data.datasource.task

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskDataSourceImpl @Inject constructor(
    private val taskDao: TaskDao
) : TaskDataSource {
    override suspend fun getAllTasks(): Result<Flow<List<Task>>> =
        runCatching {
            taskDao.getTasks()
        }

    override suspend fun insertTask(task: Task): Result<Unit> =
        runCatching {
            taskDao.insertTask(task)
        }
}