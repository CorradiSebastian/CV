package com.scorradi.cv.db.daos

import androidx.room.*
import com.scorradi.cv.db.daos.entities.Job

@Dao
interface JobDao {
    @Query("Select * from jobs")
    fun getAll():List<Job>

    @Query("Select * from jobs where id = :id")
    fun getJobById(id: Int):Job

    @Query("Select * from jobs where id = (select job_id from experiences where id = :experienceId )")
    fun getJobByExperienceId(experienceId: Int):Job

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(jobList: List<Job>)

    @Delete
    fun delete(job: Job)
}