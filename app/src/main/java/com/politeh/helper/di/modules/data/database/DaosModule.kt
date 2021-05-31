package com.politeh.helper.di.modules.data.database

import com.politeh.helper.database.HelperDatabase
import com.politeh.helper.database.daos.TaskDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DaosModule {


    @Singleton
    @Provides
    fun provideTasksDao(roomDatabase: HelperDatabase): TaskDao {
        return roomDatabase.taskDao
    }


}