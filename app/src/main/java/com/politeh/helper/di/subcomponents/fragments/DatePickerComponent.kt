package com.politeh.helper.di.subcomponents.fragments

import com.politeh.helper.ui.task.fragments.datepicker.DatePickerContract
import com.politeh.helper.ui.task.fragments.datepicker.DatePickerFragment
import com.politeh.helper.ui.task.fragments.datepicker.DatePickerPresenter
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(modules = [DatePickerComponent.ComponentModule::class])
interface DatePickerComponent {


    fun inject(fragment: DatePickerFragment)


    @Subcomponent.Factory
    interface Factory {

        fun create(@BindsInstance view: DatePickerContract.View): DatePickerComponent
    }


    @Module
    object ComponentModule {

        @Provides
        fun provideDatePickerPresenter(
            view: DatePickerContract.View
        ): DatePickerPresenter {
            return DatePickerPresenter(view)
        }
    }


}