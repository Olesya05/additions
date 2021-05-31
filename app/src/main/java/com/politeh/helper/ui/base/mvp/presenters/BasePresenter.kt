package com.politeh.helper.ui.base.mvp.presenters

abstract class BasePresenter: Presenter {

    open fun init() { }

    override fun onCreate() { }

    override fun onCreateView() { }

    override fun onViewCreated() { }

    override fun onStart() { }

    override fun onResume() { }

    override fun onPause() { }

    override fun onStop() { }

    override fun onDestroy() { }

}