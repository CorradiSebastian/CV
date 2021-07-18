package com.scorradi.cv.service.job

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
