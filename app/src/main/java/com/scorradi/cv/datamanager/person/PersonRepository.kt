package com.scorradi.cv.datamanager.person

import android.util.Log
import com.scorradi.cv.service.person.PersonDTO
import com.scorradi.cv.service.person.PersonService
import com.scorradi.cv.service.person.SocialNetworkLinkDTO
import com.scorradi.cv.db.DBManager
import com.scorradi.cv.db.daos.entities.Person
import java.util.*

class PersonRepository {
    suspend fun getPerson(): Person {

        val person = DBManager.Companion.getCvDatabase().personDao().getPerson()
        when (person){
            null -> return loadPerson()
            else -> return person
        }
    }

    suspend private fun loadPerson(): Person{
        val personDTO = PersonService().getPersonAsync()
        val person = personFromDTO(personDTO)
        DBManager.getCvDatabase().personDao().insert(person)
        return person
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