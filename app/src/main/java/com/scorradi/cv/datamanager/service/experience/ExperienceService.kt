package com.scorradi.cv.datamanager.service.experience

import com.scorradi.cv.datamanager.service.MockedRetrofitServiceBuilder

class ExperienceService {
    val retrofitServiceBuilder = MockedRetrofitServiceBuilder(8080)

    fun getExperiences():List<ExperienceDTO>{
        retrofitServiceBuilder.start()
        retrofitServiceBuilder.setDispatcher("experiences.json")
        val request = retrofitServiceBuilder.buildService(
            IExperienceService::class.java)
        val call = request.getExperiences()

        val response = call.execute()

        retrofitServiceBuilder.shutdown()

        //TODO devolver error, o lanzar excepcion
        return response.body()!!.experiences
    }


}