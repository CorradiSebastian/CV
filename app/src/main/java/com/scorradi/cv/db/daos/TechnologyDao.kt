package com.scorradi.cv.db.daos

import androidx.room.*
import com.scorradi.cv.db.daos.entities.Experience
import com.scorradi.cv.db.daos.entities.Technology

@Dao
interface TechnologyDao {
    @Query("Select * from technologies")
    fun getAll(): List<Technology>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(technologies: List<Technology>)

    @Query("DELETE FROM technologies")
    fun deleteAll()
}