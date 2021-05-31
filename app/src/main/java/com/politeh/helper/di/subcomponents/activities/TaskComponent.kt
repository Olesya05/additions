package com.politeh.helper.di.subcomponents.activities

import com.politeh.helper.data.repositories.tasks.TasksRepository
import com.politeh.helper.database.daos.TaskDao
import com.politeh.helper.ui.task.TaskActivity
import com.politeh.helper.ui.task.TaskContract
import com.politeh.helper.ui.task.TaskPresenter
import com.politeh.helper.ui.utils.DateTimeStringFormatter
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(modules = [TaskComponent.ComponentModule::class])
interface TaskComponent {


    fun inject(activity: TaskActivity)


    @Subcomponent.Factory
    interface Factory {

        fun create(@BindsInstance view: TaskContract.View): TaskComponent
    }


    @Module
    object ComponentModule {

        @Provides
        fun provideTaskPresenter(
            view: TaskContract.View,
            tasksRepository: TasksRepository,
            dateTimeStringFormatter: DateTimeStringFormatter
        ): TaskPresenter {
            return TaskPresenter(view, tasksRepository, dateTimeStringFormatter)
        }
    }


}