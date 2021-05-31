package com.politeh.helper.ui.main

import com.politeh.helper.ui.base.mvp.presenters.BasePresenter

class MainPresenter(
    private val view: MainContract.View
) : BasePresenter(),
    MainContract.ActionListener { }