package com.politeh.helper.ui.base.mvp.presenters

interface Presenter {

    fun onCreate()

    fun onCreateView()

    fun onViewCreated()

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroy()

}