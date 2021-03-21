package com.scorradi.cv.datamanager.service.job

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class JobDTO(
    val id: Int,
    val name: String,
    val companyName: String,
    val description:String,
    val responsibilities: String,
    val technologies: String,
    val libraries: String,
    val extras: String
) {
}
