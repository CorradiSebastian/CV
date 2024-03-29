package com.scorradi.cv.db.daos

import androidx.room.*
import com.scorradi.cv.db.daos.entities.Job
import com.scorradi.cv.db.daos.entities.Person

@Dao
interface PersonDao {
    @Query("Select * from persons")
    fun getAll(): List<Person>

    @Query("Select * from persons limit 1")
    fun getPerson():Person

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg person: Person)

    @Delete
    fun delete(person: Person)
}