package com.scorradi.cv.presenters
import com.scorradi.cv.db.daos.entities.Experience
import com.scorradi.cv.db.daos.entities.Person
import com.scorradi.cv.views.main.MainPresenter
import com.scorradi.cv.views.models.ExperienceModel
import com.scorradi.cv.views.models.PersonModel
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import java.util.*

class MainPresenterTest{

    @Test
    fun testLoadPerson(){
        val mainPresenter = MainPresenter(null);
        val person = Person("Sebastian Corradi", "12.345.678", Date(321782400000), "15-555-1234");
        val personModelExpected: PersonModel = PersonModel(person);
        val personModelActual = mainPresenter.loadPersonModel();
        assertEquals(personModelExpected, personModelActual)
    }

    @Test
    fun testLoadExperiences(){
        val mainPresenter = MainPresenter(null);
        val experienceActual = mainPresenter.loadExperiences()

        val experienceExpected = ArrayList<ExperienceModel>(0)
        val experience1 = Experience(1, "Google", 2, Date(321742400000), Date(321752400000))
        val experience2 = Experience(2, "Apple", 3, Date(321722400000), Date(321742400000))
        experienceExpected.add(ExperienceModel(experience1))
        experienceExpected.add(ExperienceModel(experience2))

        assertEquals(experienceExpected[0].ExperienceId, experienceActual[0].ExperienceId)
        assertEquals(experienceExpected[0].CompanyName, experienceActual[0].CompanyName)
        assertEquals(experienceExpected[0].From, experienceActual[0].From)
        assertEquals(experienceExpected[0].To, experienceActual[0].To)

        assertEquals(experienceExpected[0], experienceActual[0])
        assertEquals(experienceExpected, experienceActual)
    }
}