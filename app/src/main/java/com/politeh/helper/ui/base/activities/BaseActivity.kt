package com.politeh.helper.ui.base.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.politeh.helper.ui.base.mvp.view.BaseView

abstract class BaseActivity(layoutId: Int): AppCompatActivity(layoutId), BaseView {


    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        init()
    }


}