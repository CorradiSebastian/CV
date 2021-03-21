package com.scorradi.cv.datamanager.service.person

import com.scorradi.cv.db.daos.entities.Person
import retrofit2.Call
import retrofit2.http.GET

interface IPersonService {
    @GET("somePersonEndPoint")
    public fun getPerson(): Call<PersonResponse>
}