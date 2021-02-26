package com.scorradi.cv.DataManager

import com.scorradi.cv.db.daos.entities.Experience
import com.scorradi.cv.db.daos.entities.Person
import java.nio.file.attribute.UserDefinedFileAttributeView
import java.util.*

class DataManager {
    public fun getPerson(id: Int): Person? {
        return Person("Sebastian Corradi", Integer.toString(id), Date(321782400000), "15-555-1234")
    }
    public fun getPerson(): Person {
        return Person("Sebastian Corradi", "12.345.678", Date(321782400000), "15-555-1234")
    }

    public fun getExperiences(): ArrayList<Experience>{
        val experience1 = Experience(1, "Google", 2, Date(321742400000), Date(321752400000))
        val experience2 = Experience(2, "Apple", 3, Date(321722400000), Date(321742400000))
        val experiences = ArrayList<Experience>()
        experiences.add(experience1)
        experiences.add(experience2)
        return experiences
    }
}