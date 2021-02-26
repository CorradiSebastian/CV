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

    override fun equals(other: Any?): Boolean {
        val em: ExperienceModel = other as ExperienceModel
        return ExperienceId == em.ExperienceId &&
                CompanyName.equals(em.CompanyName) &&
                From.equals(em.From) &&
                To.equals(em.To)
    }
}