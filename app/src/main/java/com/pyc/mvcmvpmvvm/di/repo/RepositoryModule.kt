package com.pyc.mvcmvpmvvm.di.repo

import com.pyc.mvcmvpmvvm.data.repo.TaskRepository
import com.pyc.mvcmvpmvvm.data.repo.TaskRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTaskRepository(
        taskRepositoryImpl: TaskRepositoryImpl
    ) : TaskRepository
}