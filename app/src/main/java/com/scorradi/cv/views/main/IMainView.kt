package com.scorradi.cv.views.main

import android.content.Context
import com.scorradi.cv.db.daos.entities.Experience
import com.scorradi.cv.views.models.ExperienceModel
import com.scorradi.cv.views.models.PersonModel

interface IMainView {
    fun showPerson(personModel: PersonModel)
    fun showExperiences(experiences: List<ExperienceModel>)
    fun getContext(): Context
}