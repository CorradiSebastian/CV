package com.scorradi.cv.db.daos.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "companies")
class Company(
    @PrimaryKey val Name: String,
    val Description: String,
    val Area: String,
    val Country: String
) {
}