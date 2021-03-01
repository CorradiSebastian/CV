package com.scorradi.cv.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.scorradi.cv.db.daos.entities.Company

@Dao
interface CompanyDao {
    @Query("Select * from companies")
    fun getAll(): List<Company>

    @Query("Select * from companies where name = :companyName")
    fun getCompanyByName(companyName: String)

    @Insert
    fun insert(vararg companies: Company)

    @Delete
    fun delete(company: Company)
}