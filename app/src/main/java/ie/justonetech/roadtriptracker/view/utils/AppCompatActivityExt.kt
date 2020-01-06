package ie.justonetech.roadtriptracker.view.utils

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

///////////////////////////////////////////////////////////////////////////////////////////////////
// AppCompatActivityExt
// Extension utility functions for AppCompatActivity
///////////////////////////////////////////////////////////////////////////////////////////////////

fun AppCompatActivity.addFragment(@IdRes containerId: Int, fragment: Fragment) {
    with(supportFragmentManager.beginTransaction()) {
        add(containerId, fragment)
        commit()
    }
}

fun AppCompatActivity.replaceFragment(@IdRes containerId: Int, fragment: Fragment) {
    with(supportFragmentManager.beginTransaction()) {
        replace(containerId, fragment)
        commit()
    }
}

inline fun <reified T> AppCompatActivity.findFragmentById(@IdRes containerId: Int): T? {
    return supportFragmentManager.findFragmentById(containerId) as T?
}