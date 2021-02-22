package com.scorradi.cv.DataManager

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
}