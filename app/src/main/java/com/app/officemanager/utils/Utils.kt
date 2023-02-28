package com.app.officemanager.utils

import android.content.Context
import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.app.officemanager.R

object Utils {

    fun Context.replaceFragment(fragmentManager: FragmentManager, fragment: Fragment, @IdRes id: Int) {
        try {
            val backStateName = fragment.javaClass.name
            val fragmentPopped = fragmentManager.popBackStackImmediate(backStateName, 0)
            if (!fragmentPopped) { //fragment not in back stack, create it.
                //Log.e("backStateName ", "" + backStateName)
                val ft = fragmentManager.beginTransaction()
                ft.replace(id, fragment)
                ft.addToBackStack(backStateName)
                ft.commit()
            } else {
                fragmentManager.popBackStack(backStateName, 0)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun Context.getCurrentFragment(supportFragmentManager: FragmentManager, @IdRes id: Int): Fragment? {
        return supportFragmentManager.findFragmentById(id)
    }
}