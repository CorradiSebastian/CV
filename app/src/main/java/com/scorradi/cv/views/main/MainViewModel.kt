package com.scorradi.cv.views.main

import android.app.Application
import androidx.lifecycle.*
import com.scorradi.cv.datamanager.DataManager
import com.scorradi.cv.db.daos.entities.Experience
import com.scorradi.cv.views.models.ExperienceModel
import com.scorradi.cv.views.models.JobModel
import com.scorradi.cv.views.models.PersonModel
import java.util.*

class MainViewModel: AndroidViewModel, LifecycleObserver {

//class MainViewModel {

    constructor(application: Application) : super(application)

    private val dataManager = DataManager()

    val person: LiveData<PersonModel> get() = _person
    private val _person = MutableLiveData<PersonModel>()

    val experiences: LiveData<List<ExperienceModel>> get() = _experiences
    private val _experiences = MutableLiveData<List<ExperienceModel>>()

    val job: LiveData<JobModel> get() = _job
    private val _job = MutableLiveData<JobModel>()


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public fun onCreate() {
        loadPerson()
        loadExperiences()
    }

    fun loadPerson() {
        _person.value = loadPersonModel()
    }

    fun loadExperiences() {
        _experiences.value = loadExperienceModels()
    }

    fun loadPersonModel(): PersonModel {
        val person = dataManager.getPerson()
        return PersonModel(person)
    }

    fun loadExperienceModels(): List<ExperienceModel> {
        val experiencesLoaded = dataManager.getExperiences(getApplication());
        return experiencesLoaded.map<Experience, ExperienceModel> { ExperienceModel(it) }
    }

    fun onExperienceModelClick(experiendeModel: ExperienceModel) {
        _job.value = JobModel(dataManager.getJob(getApplication(), experiendeModel.experienceId))
    }
}
