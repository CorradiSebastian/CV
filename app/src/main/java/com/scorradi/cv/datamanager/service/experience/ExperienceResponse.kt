package com.scorradi.cv.datamanager.service.experience

import com.google.gson.annotations.SerializedName

class ExperienceResponse {
    @SerializedName("experiences")
    lateinit var experiences: List<ExperienceDTO>
}