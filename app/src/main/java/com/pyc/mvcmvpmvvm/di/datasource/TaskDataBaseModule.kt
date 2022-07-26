package com.pyc.mvcmvpmvvm.di.datasource

import android.content.Context
import androidx.room.Room
import com.pyc.mvcmvpmvvm.data.datasource.db.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TaskDataBaseModule {

    @Provides
    @Singleton
    fun provideAppDataBase(
        @ApplicationContext context: Context
    ): AppDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDataBase::class.java,
            AppDataBase.DB_NAME
        ).build()
    }
}