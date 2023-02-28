package com.app.officemanager

import android.app.Application

open class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initApplication()
    }

    private fun initApplication() {
        instance = this
    }

    companion object{
        lateinit var instance: App
    }
}