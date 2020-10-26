package com.scorradi.cv.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.scorradi.cv.db.daos.CompanyDao
import com.scorradi.cv.db.daos.JobDao
import com.scorradi.cv.db.daos.entities.Company
import com.scorradi.cv.db.daos.entities.Job

class CvDatabase {
    @Database(
        entities = [Company::class,
            Job::class], version = 1
    )
    abstract class CvDatabase : RoomDatabase() {
        abstract fun companyDao(): CompanyDao
        abstract fun jobDao(): JobDao
    }
}