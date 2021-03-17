package com.scorradi.cv.entities


import com.scorradi.cv.db.daos.entities.Company
import com.scorradi.cv.db.daos.entities.DateComparator
import com.scorradi.cv.db.daos.entities.Job
import com.scorradi.cv.db.daos.entities.Person
import com.scorradi.cv.views.models.PersonModel
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Assert

import org.junit.Test
import java.util.*

class entitiesTest {
    @Test
    fun company() {
        val company = Company(
            "google",
            "leading search engines since ever",
            "Internet",
            "AR"
        )
        assertTrue(company.name == "google")


        //assertTrue(job.From == Date(2010, 12,12))
        //estos tests son horribles, demasiado pavos
        //armar tests de logica o de los viewmodels, cuando los arma
    }

    @Test
    fun comparator(){
        val dates = mutableListOf(
            Date(2020, 4, 3),
            Date(2021, 5, 16),
            Date(2022, 1, 29)
        )
        assertTrue(DateComparator.compare(dates[0], dates[1]) < 0);
        assertTrue(DateComparator.compare(dates[0], dates[2]) < 0);
        Assert.assertFalse(DateComparator.compare(dates[1], dates[2]) > 0);
/*
        println("--- ASC ---")
        dates.sortedWith(compareBy { it.year }.thenBy { it.month }.thenBy { it.day })
            .forEach { println(it) }
            */
    }

    @Test
    fun person(){
        val actualPerson = getDummyPerson()
        var expectedPerson : Person = Person();
        expectedPerson.name = actualPerson.name
        expectedPerson.id = actualPerson.id
        expectedPerson.bornDate = actualPerson.bornDate
        expectedPerson.phoneNumber = actualPerson.phoneNumber

        assertEquals(actualPerson, expectedPerson);

    }

    fun getDummyPerson():Person{
        return Person("Sebastian", "12345678", Date(321782400000),  "11-5353-5353");
    }

    fun getDummyPersonalDataViewModel(): PersonModel {
        return PersonModel(getDummyPerson());
    }

    @Test
    fun personalDataViewModel(){
        val actualPersonalDataViewModel  = getDummyPersonalDataViewModel()
        var expectedPersonalDataViewModel =
            PersonModel(getDummyPerson());

        assertEquals(actualPersonalDataViewModel, expectedPersonalDataViewModel);
        //Log.e("AGE","age: " + actualPersonalDataViewModel.Age);
       assertEquals(actualPersonalDataViewModel, expectedPersonalDataViewModel);
    }
}
