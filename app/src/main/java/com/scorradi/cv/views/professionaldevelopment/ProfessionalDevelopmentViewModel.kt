package com.scorradi.cv.views.professionaldevelopment

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.*
import com.scorradi.cv.CvApplication
import com.scorradi.cv.datamanager.RepositoryManager
import com.scorradi.cv.db.daos.entities.Technology
import com.scorradi.cv.views.models.PersonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfessionalDevelopmentViewModel: AndroidViewModel, LifecycleObserver {
    constructor(application: Application) : super(application)

    val technologies: LiveData<List<Technology>> get() = _technologies
    private var _technologies = MutableLiveData<List<Technology>>()

    private val dataManager = RepositoryManager()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public fun onCreate() {
        loadTechnologies()
    }
    
    private fun loadTechnologies(){
        viewModelScope.launch(Dispatchers.IO) {
            val technologiesFromDB = dataManager.getTechnologies();
            withContext(Dispatchers.Main) {
                _technologies.value = technologiesFromDB
            }
        }
    }
}