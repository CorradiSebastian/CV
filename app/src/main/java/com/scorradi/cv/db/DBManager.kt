package com.scorradi.cv.db

import androidx.room.Room
import com.scorradi.cv.CvApplication

class DBManager {
    companion object{
        private val db = Room.databaseBuilder(
            CvApplication.applicationContext(),
            CvDatabase::class.java, "database-name"
        ).build()
        public fun getCvDatabase(): CvDatabase{
            return db
        }
    }
}
