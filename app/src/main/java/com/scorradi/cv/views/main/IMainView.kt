package com.scorradi.cv.views.main

import com.scorradi.cv.views.models.PersonModel

interface IMainView {
    fun showPerson(personModel: PersonModel)
}