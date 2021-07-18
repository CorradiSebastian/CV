package com.scorradi.cv.views.main


import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.scorradi.cv.CvApplication
import androidx.lifecycle.*
import com.scorradi.cv.datamanager.RepositoryManager
import com.scorradi.cv.db.daos.entities.Experience
import com.scorradi.cv.views.events.Event
import com.scorradi.cv.views.models.ExperienceModel
import com.scorradi.cv.views.models.JobModel
import com.scorradi.cv.views.models.PersonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel: AndroidViewModel, LifecycleObserver {

//class MainViewModel {

    constructor(application: Application) : super(application)

    private val dataManager = RepositoryManager()

    val person: LiveData<PersonModel> get() = _person
    private val _person = MutableLiveData<PersonModel>()

    val experiences: LiveData<List<ExperienceModel>> get() = _experiences
    private val _experiences = MutableLiveData<List<ExperienceModel>>()

    val job: LiveData<Event<JobModel>> get() = _job
    private val _job = MutableLiveData<Event<JobModel>>()



    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public fun onCreate() {
        //TODO use singleEvent
        //if (!created) {
        //    created = true
            loadInitialData()
        //}
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
                _person.value = personModel
            }
        }
    }

    fun loadExperiences() {
        viewModelScope.launch(Dispatchers.IO) {
            val experienceModels = loadExperienceModels()
            withContext(Dispatchers.Main) {
                _experiences.value = experienceModels
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
                _job.value = Event(JobModel(justJob))
            }
        }

    }

}
