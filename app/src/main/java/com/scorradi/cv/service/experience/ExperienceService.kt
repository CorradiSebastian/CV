package com.scorradi.cv.service.experience

import com.scorradi.cv.service.CVService
import com.scorradi.cv.service.MockedRetrofitServiceBuilder

class ExperienceService {
    private val retrofitServiceBuilder = MockedRetrofitServiceBuilder(8080)

    fun getExperiences(): List<ExperienceDTO> {
        retrofitServiceBuilder.start()
        retrofitServiceBuilder.setDispatcher("experiences.json")
        val request = retrofitServiceBuilder.buildService(
            CVService.IExperienceService::class.java
        )

        val call = request.getExperiences()

        val response = call.execute()

        retrofitServiceBuilder.shutdown()

        //TODO devolver error, o lanzar excepcion
        return response.body()!!.experiences
    }

    suspend fun getExperiencesAsync(): List<ExperienceDTO> {
        retrofitServiceBuilder.start()
        retrofitServiceBuilder.setDispatcher("experiences.json")

        val service = retrofitServiceBuilder.buildService(
            CVService.IExperienceService::class.java
        )

        var result = service.getExperiencesAsync().body()!!.experiences
        //TODO throw exception if something went worng

        retrofitServiceBuilder.shutdown()

        return result
    }

}