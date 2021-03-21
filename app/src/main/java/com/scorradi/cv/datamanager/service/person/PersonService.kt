package com.scorradi.cv.datamanager.service.person

import com.scorradi.cv.datamanager.service.MockedRetrofitServiceBuilder

class PersonService  {
    val retrofitServiceBuilder = MockedRetrofitServiceBuilder(8082)
    fun getPerson():PersonDTO{
        retrofitServiceBuilder.start()
        retrofitServiceBuilder.setDispatcher("person.json")
        val request = retrofitServiceBuilder.buildService(
            IPersonService::class.java)
        val call = request.getPerson()

        val response = call.execute()

        retrofitServiceBuilder.shutdown()

        //TODO devolver error, o lanzar excepcion
        return response.body()!!.person
    }



}