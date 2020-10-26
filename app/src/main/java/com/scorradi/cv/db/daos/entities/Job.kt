package com.scorradi.cv.db.daos.entities

import androidx.room.*
import com.scorradi.cv.db.daos.entities.Company

@Entity(tableName = "jobs", foreignKeys = [(
            ForeignKey(
                entity = Company::class,
                        parentColumns = ["Name"],
                childColumns = ["CompanyName"])
        )])

class Job(
    @PrimaryKey
    val Id: Int,
    @ColumnInfo(name = "company_name")
    val CompanyName: String,
    val role: String
) {

}