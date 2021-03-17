package com.scorradi.cv.interactors
import com.scorradi.cv.datamanager.DataManager
import com.scorradi.cv.views.models.PersonModel
import org.junit.Test

import org.junit.Assert.*

class DataInteractorTest{

    @Test
    fun testGetPersonalData(){
        val dataManager = DataManager()
        var person = dataManager.getPerson();
        var personModel = PersonModel(person)
        var personModelExpected : PersonModel? = null;
        assertEquals(personModel, personModelExpected);
    }
}