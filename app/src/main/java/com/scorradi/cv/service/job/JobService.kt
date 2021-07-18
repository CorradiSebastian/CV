package com.scorradi.cv.service.job

import com.scorradi.cv.service.CVService
import com.scorradi.cv.service.MockedRetrofitServiceBuilder

class JobService {
    val retrofitServiceBuilder = MockedRetrofitServiceBuilder(8081)

    fun getJobs():List<JobDTO>{
        retrofitServiceBuilder.start()
        retrofitServiceBuilder.setDispatcher("jobs.json")
        val request = retrofitServiceBuilder.buildService(
            CVService.IJobService::class.java)
        val call = request.getJobs()

        val response = call.execute()

        retrofitServiceBuilder.shutdown()

        //TODO devolver error, o lanzar excepcion
        return response.body()!!.jobs
    }

    suspend fun getJobsAsync():List<JobDTO>{
        retrofitServiceBuilder.start()
        retrofitServiceBuilder.setDispatcher("jobs.json")
        val service = retrofitServiceBuilder.buildService(
            CVService.IJobService::class.java)

        val result = service.getJobsAsync().body()!!.jobs
        //TODO throw exception if something went worng
        retrofitServiceBuilder.shutdown()

        return result;

    }

}