package com.scorradi.cv.views.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.scorradi.cv.datamanager.DataManager
import com.scorradi.cv.db.daos.entities.Experience
import com.scorradi.cv.views.models.ExperienceModel
import com.scorradi.cv.views.models.JobModel
import com.scorradi.cv.views.models.PersonModel

class MainViewModel: AndroidViewModel {

    constructor(application: Application) : super(application)
    private val dataManager = DataManager()

    val person = MutableLiveData<PersonModel>()
    val experiences = MutableLiveData<List<ExperienceModel>>()
    val job = MutableLiveData<JobModel>()

    public fun onCreate() {
        loadPerson()
        loadExperiences()
    }

    fun loadPerson(){
        person.value = loadPersonModel()
    }

    fun loadExperiences(){
        experiences.value = loadExperienceModels()
    }

    fun loadPersonModel(): PersonModel{
        val  person = dataManager.getPerson()
        return PersonModel(person)
    }

    fun loadExperienceModels():List<ExperienceModel>{
        val experiences =  dataManager.getExperiences(getApplication());
        return experiences.map<Experience, ExperienceModel> { ExperienceModel(it) }
    }

    fun experienceModelClicked(experiendeModel: ExperienceModel){
        job.value = JobModel(dataManager.getJob(getApplication(), experiendeModel.experienceId))
    }
}
