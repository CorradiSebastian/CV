package com.scorradi.cv.views.main

import com.scorradi.cv.DataManager.DataManager
import com.scorradi.cv.interactors.DataInteractor
import com.scorradi.cv.views.models.PersonModel

class MainPresenter(val mainView: IMainView) {
    private val dataManager = DataManager()

    public fun onCreate() {
        val  person = dataManager.getPerson()

        person?.let {
            val personModel:PersonModel = PersonModel(it);
            mainView.showPerson(personModel)
        }

    }
}
