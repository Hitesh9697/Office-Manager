package com.app.officemanager.ui.fragments

import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(), View.OnClickListener{

    protected abstract fun initView()

    protected abstract fun initListener()

    protected abstract fun initObserver()
}