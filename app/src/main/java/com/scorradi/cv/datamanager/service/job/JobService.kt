package com.scorradi.cv.datamanager.service.job

import com.scorradi.cv.datamanager.service.MockedRetrofitServiceBuilder

class JobService {
    val retrofitServiceBuilder = MockedRetrofitServiceBuilder(8081)

    fun getJobs():List<JobDTO>{
        retrofitServiceBuilder.start()
        retrofitServiceBuilder.setDispatcher("jobs.json")
        val request = retrofitServiceBuilder.buildService(
            IJobService::class.java)
        val call = request.getJobs()

        val response = call.execute()

        retrofitServiceBuilder.shutdown()

        //TODO devolver error, o lanzar excepcion
        return response.body()!!.jobs
    }


}