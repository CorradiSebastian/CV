package com.scorradi.cv.views.models

import com.scorradi.cv.db.daos.entities.Experience
import java.util.*

data class ExperienceModel(val experience: Experience) {
    val experienceId: Int = experience.Id
    //var role: String:
    val companyName: String = experience.companyName
    val from: Date = experience.from
    val to: Date = experience.to
    val role: String = experience.role

    companion object {
        val KEY_EXPERIENCE_ID = "ExperienceId"
        val KEY_COMPANY_NAME = "CompanyName"
        val KEY_FROM = "From"
        val KEY_TO = "To"
        val ROLE = "Role"
    }
}