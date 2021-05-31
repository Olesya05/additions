package com.politeh.helper.di.subcomponents.interfaces

import com.politeh.helper.di.subcomponents.activities.MainComponent
import com.politeh.helper.di.subcomponents.activities.TaskComponent

interface ExposeActivitySubcomponents {

    fun createMainComponent(): MainComponent.Factory

    fun createTaskComponent() :TaskComponent.Factory
}
