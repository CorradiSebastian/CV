package com.scorradi.cv.service.technology

import com.google.gson.annotations.SerializedName
import com.scorradi.cv.service.job.JobDTO

class TechnologyResponse {
    @SerializedName("technologies")
    lateinit var technologies:List<TechnologyDTO>
}
