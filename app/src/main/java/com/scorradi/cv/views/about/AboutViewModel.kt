package com.scorradi.cv.views.about

import android.app.Application
import androidx.lifecycle.*
import com.scorradi.cv.datamanager.RepositoryManager
import com.scorradi.cv.views.models.PersonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AboutViewModel: AndroidViewModel, LifecycleObserver {
    constructor(application: Application) : super(application)

    private val dataManager = RepositoryManager()

    val person: LiveData<PersonModel> get() = _person
    private val _person = MutableLiveData<PersonModel>()

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        loadPerson()
    }

    fun loadPerson() {
        viewModelScope.launch(Dispatchers.IO) {
            val personModel = loadPersonModel()
            withContext(Dispatchers.Main) {
                _person.value = personModel
            }
        }
    }

    suspend fun loadPersonModel(): PersonModel {
        val person = dataManager.getPerson()
        return PersonModel(person)
    }

}