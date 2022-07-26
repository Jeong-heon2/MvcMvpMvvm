package com.pyc.mvcmvpmvvm.data.datasource.task

import kotlinx.coroutines.flow.Flow

interface TaskDataSource {
    suspend fun getAllTasks(): Result<Flow<List<Task>>>

    suspend fun insertTask(task: Task): Result<Unit>
}