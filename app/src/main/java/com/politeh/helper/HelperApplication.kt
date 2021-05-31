package com.politeh.helper

import android.app.Application
import com.politeh.helper.di.DaggerHelperAppComponent
import com.politeh.helper.di.HelperAppComponent
class HelperApplication : Application() {


    private lateinit var appComponent: HelperAppComponent


    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerHelperAppComponent.factory().create(applicationContext)

    }


    fun getAppComponent() : HelperAppComponent {
        return appComponent
    }
}