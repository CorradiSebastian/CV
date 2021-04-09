package com.scorradi.cv.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.scorradi.cv.db.daos.entities.Job

@Dao
interface JobDao {
    @Query("Select * from jobs")
    fun getAll():List<Job>

    @Query("Select * from jobs where id = :id")
    fun getJobById(id: Int):Job

    @Query("Select * from jobs where id = (select job_id from experiences where id = :experienceId )")
    fun getJobByExperienceId(experienceId: Int):Job

    @Insert
    fun insertAll(jobList: List<Job>)

    @Delete
    fun delete(job: Job)
}