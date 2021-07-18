package com.scorradi.cv.service.experience

data class ExperienceDTO(
    val id: Int,
    val companyName: String,
    val jobId: Int,
    val from: Long,
    val to: Long
) {
}
