package com.scorradi.cv.views.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scorradi.cv.CvApplication
import com.scorradi.cv.datamanager.DataManager
import com.scorradi.cv.db.daos.entities.Experience
import com.scorradi.cv.views.events.Event
import com.scorradi.cv.views.models.ExperienceModel
import com.scorradi.cv.views.models.JobModel
import com.scorradi.cv.views.models.PersonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel() : ViewModel() {


    private val dataManager = DataManager()

    val person = MutableLiveData<PersonModel>()
    val experiences = MutableLiveData<List<ExperienceModel>>()
    val job = MutableLiveData<Event<JobModel>>()
    var created = false

    public fun onCreate() {
        if (!created) {
            created = true
            loadInitialData()
        }
    }

    private fun loadInitialData() {
//        viewModelScope.launch {
//            val personModel = async(Dispatchers.IO) {
//                loadPersonModel()
//            }
//            val experienceModels = async(Dispatchers.IO) {
//                loadExperienceModels()
//            }
//            //aca usaria personModel.await y experienceModels.await
//    }

        loadPerson()
        loadExperiences()

    }

    fun loadPerson() {
        viewModelScope.launch(Dispatchers.IO) {
            val personModel = loadPersonModel()
            withContext(Dispatchers.Main) {
                person.value = personModel
            }
        }
    }

    fun loadExperiences() {
        viewModelScope.launch(Dispatchers.IO) {
            val experienceModels = loadExperienceModels()
            withContext(Dispatchers.Main) {
                experiences.value = experienceModels
            }
        }
    }

    fun loadPersonModel(): PersonModel {
        val person = dataManager.getPerson()
        return PersonModel(person)
    }

    fun loadExperienceModels(): List<ExperienceModel> {
        val experiences = dataManager.getExperiences();
        return experiences.map<Experience, ExperienceModel> { ExperienceModel(it) }

    }

    fun experienceModelClicked(experiendeModel: ExperienceModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val justJob =
                dataManager.getJob(CvApplication.applicationContext(), experiendeModel.experienceId)
            withContext(Dispatchers.Main) {
                job.value = Event(JobModel(justJob))
            }
        }
    }

}
