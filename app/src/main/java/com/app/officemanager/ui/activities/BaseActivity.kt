package com.app.officemanager.ui.activities

import android.view.View
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), View.OnClickListener{

    protected abstract fun initView()

    protected abstract fun initListener()

    protected abstract fun initObserver()
}