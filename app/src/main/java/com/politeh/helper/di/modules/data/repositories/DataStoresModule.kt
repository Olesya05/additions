package com.politeh.helper.di.modules.data.repositories

import com.politeh.helper.data.stores.tasks.TasksDatabaseStore
import com.politeh.helper.database.daos.TaskDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DataStoresModule {


    @Singleton
    @Provides
    fun provideTasksDatabaseStore(taskDao: TaskDao): TasksDatabaseStore {
        return TasksDatabaseStore(taskDao)
    }
}