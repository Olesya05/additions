package com.politeh.helper.ui.base.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.politeh.helper.ui.base.mvp.view.BaseView

abstract class BaseFragment(private val layoutId: Int): Fragment(),
    BaseView {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        injectDependencies()
        super.onViewCreated(view, savedInstanceState)
        init()
    }


}