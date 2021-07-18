package com.scorradi.cv.views.splash

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.scorradi.cv.datamanager.RepositoryManager
import kotlinx.coroutines.*

class SplashViewModel() : ViewModel() {
    val dataLoaded = MutableLiveData<Boolean>()
    var created = false

    private val dataManager = RepositoryManager()

    public fun splashCreated() {
        if (!created) {
            created = true
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    RepositoryManager().loadData()
                    withContext(Dispatchers.Main) {
                        dataLoaded.value = true;
                    }
                } catch (e: Exception){
                    withContext(Dispatchers.Main){
                        Log.e("SplashviewModel", "MainThread, ${e.toString()}")
                    }
                }
            }
        }
        //TODO read JSONs and load the DB
        //THEN the dataMAnager will load everithing from the DB
    }
}