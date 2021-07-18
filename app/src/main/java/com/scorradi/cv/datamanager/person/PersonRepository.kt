package com.scorradi.cv.datamanager.person

import android.util.Log
import com.scorradi.cv.service.person.PersonDTO
import com.scorradi.cv.service.person.PersonService
import com.scorradi.cv.service.person.SocialNetworkLinkDTO
import com.scorradi.cv.db.DBManager
import com.scorradi.cv.db.daos.entities.Person
import java.util.*

class PersonRepository {
    fun getPerson(): Person {
        //val personDTO = PersonService().getPerson()
        val person = DBManager.Companion.getCvDatabase().personDao().getPersonById("12.345.678")
        return person
    }

    suspend fun loadPerson(){
        val personDTO = PersonService().getPersonAsync()
        val person = personFromDTO(personDTO)
        DBManager.getCvDatabase().personDao().insert(person)
        Log.d("PersonRepository", "Async Check")
    }

    private fun personFromDTO(personDTO: PersonDTO): Person{
        return Person(personDTO.name,
                      personDTO.id,
                      Date(personDTO.bornDate),
                      personDTO.phoneNumber,
                      personDTO.networkLinks.map<SocialNetworkLinkDTO, SocialNetworkLink> {
                          SocialNetworkLink(it.name, it.url) }
                        )
    }
}