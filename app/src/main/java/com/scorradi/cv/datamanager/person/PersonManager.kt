package com.scorradi.cv.datamanager.person

import com.scorradi.cv.datamanager.service.person.PersonDTO
import com.scorradi.cv.datamanager.service.person.PersonService
import com.scorradi.cv.datamanager.service.person.SocialNetworkLinkDTO
import com.scorradi.cv.db.DBManager
import com.scorradi.cv.db.daos.entities.Person
import java.util.*

class PersonManager {
    fun getPerson(): Person {
        //val personDTO = PersonService().getPerson()
        val person = DBManager.Companion.getCvDatabase().personDao().getPersonById("12.345.678")
        return person
    }

    fun loadPerson(){
        val personDTO = PersonService().getPerson()
        val person = personFromDTO(personDTO)
        DBManager.getCvDatabase().personDao().insertAll(person)
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