package com.pyc.mvcmvpmvvm.di.datasource

import com.pyc.mvcmvpmvvm.data.datasource.db.AppDataBase
import com.pyc.mvcmvpmvvm.data.datasource.task.TaskDataSource
import com.pyc.mvcmvpmvvm.data.datasource.task.TaskDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TaskDataSourceModule {

    @Binds
    @Singleton
    internal abstract fun bindTaskDataSource(
        taskDataSourceImpl: TaskDataSourceImpl
    ): TaskDataSource

    companion object {

        @Provides
        @Singleton
        internal fun provideTaskDao(
            appDataBase: AppDataBase
        ) = appDataBase.tasksDao()
    }
}