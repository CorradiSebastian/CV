package com.scorradi.cv.views.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.scorradi.cv.datamanager.DataManager

class SplashViewModel(application: Application) : AndroidViewModel(application) {
    private val dataManager = DataManager()
    public fun splashCreated() {
        //TODO read JSONs and load the DB
        //THEN the dataMAnager will load everithing from the DB
    }
}