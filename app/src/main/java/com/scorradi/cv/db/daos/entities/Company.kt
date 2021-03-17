package com.scorradi.cv.db.daos.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "companies")
class Company(
    @PrimaryKey val name: String,
    val description: String,
    val area: String,
    val country: String
) {
}