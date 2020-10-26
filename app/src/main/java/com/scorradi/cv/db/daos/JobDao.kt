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
    fun getJobById(id: Int)

    @Insert
    fun insertAll(vararg jobs: Job)

    @Delete
    fun delete(job: Job)
}