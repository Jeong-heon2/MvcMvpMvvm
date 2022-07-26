package com.pyc.mvcmvpmvvm.data.datasource.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pyc.mvcmvpmvvm.data.datasource.task.Task
import com.pyc.mvcmvpmvvm.data.datasource.task.TaskDao

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun tasksDao() : TaskDao

    companion object {
        const val DB_NAME = "tasks.db"
    }
}