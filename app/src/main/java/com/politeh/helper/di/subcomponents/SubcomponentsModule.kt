package com.politeh.helper.di.subcomponents

import com.politeh.helper.di.subcomponents.activities.ActivitiesModule
import com.politeh.helper.di.subcomponents.activities.MainComponent
import com.politeh.helper.di.subcomponents.fragments.FragmentsModule
import dagger.Module

@Module(
    includes = [
        ActivitiesModule::class,
        FragmentsModule::class
    ]
)
object SubcomponentsModule