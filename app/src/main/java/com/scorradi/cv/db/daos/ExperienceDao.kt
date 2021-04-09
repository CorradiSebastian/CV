package com.scorradi.cv.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.scorradi.cv.db.daos.entities.Experience

@Dao
interface ExperienceDao {

    @Query("Select * from experiences")
    fun getAll(): List<Experience>

    @Query("Select * from experiences where Id = :experienceId")
    fun getExperienceById(experienceId: Int):Experience

    @Delete
    fun delete(experience: Experience)

    @Insert
    fun insertAll(experiences: List<Experience>)

}