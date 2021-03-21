package com.scorradi.cv.datamanager.service.job

import com.google.gson.annotations.SerializedName
import com.scorradi.cv.db.daos.entities.Job

class JobResponse {
    @SerializedName("jobs")
    lateinit var jobs:List<JobDTO>
}