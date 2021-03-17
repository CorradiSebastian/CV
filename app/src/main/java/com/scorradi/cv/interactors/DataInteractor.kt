package com.scorradi.cv.interactors

import com.scorradi.cv.datamanager.DataManager
import com.scorradi.cv.db.daos.entities.Person
import java.util.*

class DataInteractor {

    private val dataManager: DataManager = TODO();

    public fun getPersonalData(): Person{
        //return dataManager.getPerson();
        return Person("Sebastian Corradi", "12.345.678", Date(321782400000), "15-555-1234")
    }
}