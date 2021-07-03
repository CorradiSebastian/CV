package com.scorradi.cv.views.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.scorradi.cv.datamanager.DataManager
import com.scorradi.cv.views.models.PersonModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashViewModel() : ViewModel() {
    val dataLoaded = MutableLiveData<Boolean>()
    var created = false

    private val dataManager = DataManager()

    public fun splashCreated() {
        if (!created) {
            created = true
            CoroutineScope(Dispatchers.IO).launch {
                DataManager().loadData()
                withContext(Dispatchers.Main){
                    dataLoaded.value = true;
                }
            }
        }
        //TODO read JSONs and load the DB
        //THEN the dataMAnager will load everithing from the DB
    }
}