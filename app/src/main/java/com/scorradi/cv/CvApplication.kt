package com.scorradi.cv

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho

class CvApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: CvApplication? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        // initialize for any

        // Use ApplicationContext.
        // example: SharedPreferences etc...
        val context: Context = CvApplication.applicationContext()

        Stetho.initializeWithDefaults(this)
    }
}