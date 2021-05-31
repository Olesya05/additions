package com.politeh.helper.di.subcomponents.activities

import com.politeh.helper.ui.main.MainActivity
import com.politeh.helper.ui.main.MainContract
import com.politeh.helper.ui.main.MainPresenter
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(modules = [MainComponent.ComponentModule::class])
interface MainComponent {


    fun inject(activity: MainActivity)


    @Subcomponent.Factory
    interface Factory {

        fun create(@BindsInstance view: MainContract.View): MainComponent
    }


    @Module
    object ComponentModule {

        @Provides
        fun provideMainPresenter(
            view: MainContract.View
        ): MainPresenter {
            return MainPresenter(view)
        }
    }


}