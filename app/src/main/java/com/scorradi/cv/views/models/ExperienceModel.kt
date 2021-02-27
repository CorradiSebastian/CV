package com.scorradi.cv.views.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.scorradi.cv.db.daos.entities.Experience
import java.util.*
import kotlin.math.exp

data class ExperienceModel(val experience: Experience) {
    val ExperienceId: Int = experience.Id
    val CompanyName: String = experience.CompanyName
    val From: Date = experience.From
    val To: Date = experience.To

    companion object {
        val KEY_EXPERIENCE_ID = "ExperienceId"
        val KEY_COMPANY_NAME = "CompanyName"
        val KEY_FROM = "From"
        val KEY_TO = "To"
    }
}