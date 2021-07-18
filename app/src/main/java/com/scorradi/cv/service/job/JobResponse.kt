package com.scorradi.cv.service.job

import com.google.gson.annotations.SerializedName

class JobResponse {
    @SerializedName("jobs")
    lateinit var jobs:List<JobDTO>
}