package com.scorradi.cv.datamanager.person

import com.scorradi.cv.datamanager.service.person.PersonDTO
import com.scorradi.cv.datamanager.service.person.PersonService
import com.scorradi.cv.db.daos.entities.Person
import java.util.*

class PersonManager {
    fun getPerson(): Person {
        val personDTO = PersonService().getPerson()
        return personFromDTO(personDTO)
    }

    private fun personFromDTO(personDTO: PersonDTO): Person{
        return Person(personDTO.name,
                      personDTO.id,
                      Date(personDTO.bornDate),
                      personDTO.phoneNumber )
    }
}