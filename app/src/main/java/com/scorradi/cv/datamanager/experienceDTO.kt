package com.scorradi.cv.datamanager

data class ExperienceDTO(
    val id: Int,
    val companyName: String,
    val jobId: Int,
    val from: Long,
    val to: Long
) {
}
