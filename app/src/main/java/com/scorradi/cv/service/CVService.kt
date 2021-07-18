package com.scorradi.cv.service

import com.scorradi.cv.service.experience.ExperienceResponse
import com.scorradi.cv.service.job.JobResponse
import com.scorradi.cv.service.person.PersonResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

class CVService {
    interface IPersonService {
        @GET("somePersonEndPoint")
        public fun getPerson(): Call<PersonResponse>

        @GET("somePersonEndPoint")
        suspend fun getPersonAsync(): Response<PersonResponse>
    }
    interface IExperienceService {
        @GET("someEndPoint")
        public fun getExperiences(): Call<ExperienceResponse>

        @GET("someEndPoint")
        suspend fun getExperiencesAsync(): Response<ExperienceResponse>

    }
    interface IJobService {
        @GET("someEndPoint")
        public fun getJobs(): Call<JobResponse>

        @GET("someEndPoint")
        suspend fun getJobsAsync(): Response<JobResponse>
    }

}