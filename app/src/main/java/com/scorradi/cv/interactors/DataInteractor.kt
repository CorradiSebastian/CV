package com.scorradi.cv.interactors

import com.scorradi.cv.datamanager.RepositoryManager
import com.scorradi.cv.datamanager.person.SocialNetworkLink
import com.scorradi.cv.db.daos.entities.Person
import java.util.*
import kotlin.collections.ArrayList

class DataInteractor {

    private val repositoryManager: RepositoryManager = TODO();

    public fun getPersonalData(): Person{
        //return dataManager.getPerson();
        return Person("Sebastian Corradi", "12.345.678", Date(321782400000), "15-555-1234", ArrayList<SocialNetworkLink>())
    }
}