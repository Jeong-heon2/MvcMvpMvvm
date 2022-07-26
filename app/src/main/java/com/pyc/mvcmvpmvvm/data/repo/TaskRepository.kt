package com.pyc.mvcmvpmvvm.data.repo

import com.pyc.mvcmvpmvvm.data.datasource.task.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun getAllTasks(): Result<Flow<List<Task>>>

    suspend fun insertTask(task: Task): Result<Unit>
}