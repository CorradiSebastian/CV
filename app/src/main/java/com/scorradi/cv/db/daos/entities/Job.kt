package com.scorradi.cv.db.daos.entities

import androidx.room.*
import com.scorradi.cv.db.daos.entities.Company

@Entity(tableName = "jobs", foreignKeys = [
//    (  ForeignKey(
//                entity = Company::class,
//                        parentColumns = ["name"],
//                childColumns = ["company_name"])
//            )
    ])

class Job(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "role")
    val role: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description:String,
    @ColumnInfo(name = "responsibilities")
    val responsibilities: String,
    @ColumnInfo(name = "technologies")
    val technologies: String,
    @ColumnInfo(name = "libraries")
    val libraries: String,
    @ColumnInfo(name = "extras")
    val extras: String
    ) {

}