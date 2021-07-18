package com.scorradi.cv.service.person

import com.scorradi.cv.service.CVService
import com.scorradi.cv.service.MockedRetrofitServiceBuilder

class PersonService {
    val retrofitServiceBuilder = MockedRetrofitServiceBuilder(8082)
    fun getPerson(): PersonDTO {
        retrofitServiceBuilder.start()
        retrofitServiceBuilder.setDispatcher("person.json")
        val request = retrofitServiceBuilder.buildService(
            CVService.IPersonService::class.java
        )
        val call = request.getPerson()

        val response = call.execute()

        retrofitServiceBuilder.shutdown()

        //TODO devolver error, o lanzar excepcion
        return response.body()!!.person
    }

    suspend fun getPersonAsync(): PersonDTO {
        retrofitServiceBuilder.start()
        retrofitServiceBuilder.setDispatcher("person.json")
        val request = retrofitServiceBuilder.buildService(
            CVService.IPersonService::class.java
        )

        val result = request.getPersonAsync().body()!!.person

        retrofitServiceBuilder.shutdown()
        return result
    }

}