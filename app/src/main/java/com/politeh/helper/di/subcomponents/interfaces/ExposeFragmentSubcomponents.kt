package com.politeh.helper.di.subcomponents.interfaces

import com.politeh.helper.di.subcomponents.fragments.DatePickerComponent
import com.politeh.helper.di.subcomponents.fragments.TasksComponent
import com.politeh.helper.di.subcomponents.fragments.TimePickerComponent
import com.politeh.helper.di.subcomponents.fragments.WeatherComponent

interface ExposeFragmentSubcomponents {

    fun createTasksComponent(): TasksComponent.Factory
    fun createWeatherComponent(): WeatherComponent.Factory

    fun createDatePickerComponent(): DatePickerComponent.Factory
    fun createTimePickerComponent(): TimePickerComponent.Factory
}