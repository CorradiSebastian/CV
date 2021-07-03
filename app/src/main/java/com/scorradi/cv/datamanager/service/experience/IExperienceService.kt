package com.scorradi.cv.datamanager.service.experience

import retrofit2.Call
import retrofit2.http.GET

interface IExperienceService {
    @GET("someEndPoint")
    public fun getExperiences(): Call<ExperienceResponse>
}