package com.scorradi.cv.db.daos.entities

import androidx.room.*
import java.util.*

@Entity(tableName = "technologies")

data class Technology(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "Description")
    val description: String,
){
    @PrimaryKey(autoGenerate = true)
    var Id: Int = 0

}
