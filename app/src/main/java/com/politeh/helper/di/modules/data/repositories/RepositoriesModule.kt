package com.politeh.helper.di.modules.data.repositories

import com.politeh.helper.data.repositories.tasks.TasksRepository
import com.politeh.helper.data.repositories.tasks.TasksRepositoryImpl
import com.politeh.helper.data.stores.tasks.TasksDatabaseStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoriesModule {


    @Singleton
    @Provides
    fun provideTasksRepository(tasksDatabaseStore: TasksDatabaseStore): TasksRepository {
        return TasksRepositoryImpl(tasksDatabaseStore)
    }


}