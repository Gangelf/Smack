package com.example.gangelf.smack.Controller

import android.app.Application
import com.example.gangelf.smack.Utilities.SharedPrefs

/**
 * Created by Gangelf on 2/25/2018.
 */
class App : Application() {

    companion object {
        lateinit var prefs: SharedPrefs
    }

    override fun onCreate() {
        prefs = SharedPrefs(applicationContext)
        super.onCreate()
    }

}