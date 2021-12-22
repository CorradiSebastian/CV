package com.scorradi.cv.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.scorradi.cv.db.daos.*
import com.scorradi.cv.db.daos.entities.*

@Database(
    entities = [Company::class,
        Job::class,
        Experience::class,
        Person::class,
        Technology::class], version = 2
)
@TypeConverters(Converters::class)
abstract class CvDatabase : RoomDatabase() {
    abstract fun companyDao(): CompanyDao
    abstract fun jobDao(): JobDao
    abstract fun personDao(): PersonDao
    abstract fun experienceDao(): ExperienceDao
    abstract fun technologyDao(): TechnologyDao
}
