package com.scorradi.cv.views.main

import com.scorradi.cv.DataManager.DataManager
import com.scorradi.cv.db.daos.entities.Experience
import com.scorradi.cv.views.models.ExperienceModel
import com.scorradi.cv.views.models.PersonModel

class MainPresenter(private val mainView: IMainView?) {
    private val dataManager = DataManager()

    public fun onCreate() {
        showPerson()
        showExperiences()
    }

    fun showPerson(){
        val person = loadPersonModel()
        mainView?.showPerson(person)
    }

    fun showExperiences(){
        val experiences = loadExperienceModels()
        mainView?.showExperiences(experiences)
    }

    fun loadPersonModel(): PersonModel{
        val  person = dataManager.getPerson()

        person?.let {
            val personModel:PersonModel = PersonModel(it);
            return personModel;
        }
    }

    fun loadExperienceModels():List<ExperienceModel>{
        val experiences =  dataManager.getExperiences();
        return experiences.map<Experience, ExperienceModel> { ExperienceModel(it) }
    }
}
