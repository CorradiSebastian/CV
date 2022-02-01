package com.scorradi.cv.db.daos

import androidx.room.*
import com.google.android.material.circularreveal.CircularRevealHelper
import com.scorradi.cv.db.daos.entities.Experience

@Dao
interface ExperienceDao {

    @Query("Select experiences.Id, experiences.company_name, experiences.job_id, experiences.`from`, experiences.`to`,  jobs.role as role  from experiences inner join jobs on experiences.job_id = jobs.id")
    fun getAll(): List<Experience>

    @Query("Select * from experiences where Id = :experienceId")
    fun getExperienceById(experienceId: Int):Experience

    @Delete
    fun delete(experience: Experience)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(experiences: List<Experience>)

}