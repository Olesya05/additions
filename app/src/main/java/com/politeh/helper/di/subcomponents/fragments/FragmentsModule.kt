package com.politeh.helper.di.subcomponents.fragments

import com.politeh.helper.di.subcomponents.activities.MainComponent
import dagger.Module

@Module(
    subcomponents = [
        TasksComponent::class,
        WeatherComponent::class
    ]
)
class FragmentsModule