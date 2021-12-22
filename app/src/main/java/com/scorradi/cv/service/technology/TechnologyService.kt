package com.scorradi.cv.service.technology

import com.scorradi.cv.service.CVService
import com.scorradi.cv.service.MockedRetrofitServiceBuilder
import com.scorradi.cv.service.job.JobDTO

class TechnologyService {
    val retrofitServiceBuilder = MockedRetrofitServiceBuilder(8081)

    fun getTechnologies():List<TechnologyDTO>{
        retrofitServiceBuilder.start()
        retrofitServiceBuilder.setDispatcher("technologies.json")
        val request = retrofitServiceBuilder.buildService(
            CVService.ITechnologyService::class.java)
        val call = request.getTechnologies()

        val response = call.execute()

        retrofitServiceBuilder.shutdown()

        //TODO devolver error, o lanzar excepcion
        return response.body()!!.technologies
    }
}