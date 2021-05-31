package com.politeh.helper.di.subcomponents.fragments

import com.politeh.helper.data.repositories.tasks.TasksRepository
import com.politeh.helper.data.repositories.tasks.TasksRepositoryImpl
import com.politeh.helper.database.daos.TaskDao
import com.politeh.helper.ui.main.tasks.TasksContract
import com.politeh.helper.ui.main.tasks.TasksFragment
import com.politeh.helper.ui.main.tasks.TasksPresenter
import com.politeh.helper.ui.utils.DateTimeStringFormatter
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(modules = [TasksComponent.ComponentModule::class])
interface TasksComponent {


    fun inject(fragment: TasksFragment)


    @Subcomponent.Factory
    interface Factory {

        fun create(@BindsInstance view: TasksContract.View): TasksComponent
    }


    @Module
    object ComponentModule {


        @Provides
        fun provideTasksPresenter(
            view: TasksContract.View,
            tasksRepository: TasksRepository
        ): TasksPresenter {
            return TasksPresenter(view, tasksRepository)
        }
    }


}