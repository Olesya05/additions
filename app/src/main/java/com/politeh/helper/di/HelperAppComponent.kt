package com.politeh.helper.di

import android.content.Context
import com.politeh.helper.di.modules.core.CoreModule
import com.politeh.helper.di.modules.data.DataModule
import com.politeh.helper.di.subcomponents.interfaces.ExposeActivitySubcomponents
import com.politeh.helper.di.subcomponents.interfaces.ExposeFragmentSubcomponents
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    CoreModule::class,
    DataModule::class
])
interface HelperAppComponent: ExposeActivitySubcomponents,
    ExposeFragmentSubcomponents {


    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context) : HelperAppComponent
    }


}