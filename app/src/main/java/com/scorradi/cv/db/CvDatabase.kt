package com.scorradi.cv.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.scorradi.cv.db.daos.CompanyDao
import com.scorradi.cv.db.daos.ExperienceDao
import com.scorradi.cv.db.daos.JobDao
import com.scorradi.cv.db.daos.PersonDao
import com.scorradi.cv.db.daos.entities.Company
import com.scorradi.cv.db.daos.entities.Experience
import com.scorradi.cv.db.daos.entities.Job
import com.scorradi.cv.db.daos.entities.Person

@Database(
    entities = [Company::class,
        Job::class,
        Experience::class,
        Person::class], version = 1
)
@TypeConverters(Converters::class)
abstract class CvDatabase : RoomDatabase() {
    abstract fun companyDao(): CompanyDao
    abstract fun jobDao(): JobDao
    abstract fun personDao(): PersonDao
    abstract fun experienceDao(): ExperienceDao
}
