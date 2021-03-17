package com.scorradi.cv.views.models

import com.scorradi.cv.db.daos.entities.Person
import java.util.*

data class PersonModel(val person: Person) {
    val Name = person.name
    val Id = person.id
    val PhoneNumber = person.phoneNumber
    val Age = calculateAge(person.bornDate)

    //TODO la logica no tiene que ir acá, de ultima un factory inyectado
    private fun calculateAge(date: Date): Int{
        val dob  = GregorianCalendar()
        dob.time = date

        val today = Calendar.getInstance()

        var age = today[Calendar.YEAR] - dob[Calendar.YEAR]

        if (today[Calendar.DAY_OF_YEAR] < dob[Calendar.DAY_OF_YEAR]) {
            age--
        }

        return age
    }
}