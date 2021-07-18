package com.scorradi.cv.service.experience

import com.google.gson.annotations.SerializedName

class ExperienceResponse {
    @SerializedName("experiences")
    lateinit var experiences: List<ExperienceDTO>
}