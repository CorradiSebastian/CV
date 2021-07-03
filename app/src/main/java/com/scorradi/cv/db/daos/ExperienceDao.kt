package com.scorradi.cv.db.daos

import androidx.room.*
import com.google.android.material.circularreveal.CircularRevealHelper
import com.scorradi.cv.db.daos.entities.Experience

@Dao
interface ExperienceDao {

    @Query("Select * from experiences")
    fun getAll(): List<Experience>

    @Query("Select * from experiences where Id = :experienceId")
    fun getExperienceById(experienceId: Int):Experience

    @Delete
    fun delete(experience: Experience)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(experiences: List<Experience>)

}