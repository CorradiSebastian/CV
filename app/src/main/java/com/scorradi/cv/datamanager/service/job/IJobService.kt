package com.scorradi.cv.datamanager.service.job

import retrofit2.Call
import retrofit2.http.GET

interface IJobService {
    @GET("someEndPoint")
    public fun getJobs(): Call<JobResponse>
}