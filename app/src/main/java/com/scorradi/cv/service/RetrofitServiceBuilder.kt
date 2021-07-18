package com.scorradi.cv.service

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.scorradi.cv.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.logging.Level

open class RetrofitServiceBuilder {
    protected var serverUrl: String = "http://SomeURL.com/SomeSubDomain/"

    private var httpClient = OkHttpClient.Builder()
    private var builder: Retrofit.Builder? = null
    private var retrofit = buildRetrofit()

    private fun buildRetrofit(): Retrofit {
        if (builder == null) {
            builder = retrofit2.Retrofit.Builder()
                .baseUrl(serverUrl)
                .addConverterFactory(GsonConverterFactory.create())
        }
        if (BuildConfig.DEBUG) {
            //addStethoInterceptor(httpClient)
        }
        builder!!
            .baseUrl(serverUrl)
            .client(httpClient!!
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                })
                .build())
        return builder!!.build()
    }

    //Change the URL (to allow mocked data) and rebuild  retrofit instance
    fun setServer(serverUrl: String) {
        this.serverUrl = serverUrl
        retrofit = buildRetrofit()
    }

    fun <S> buildService(serviceClass: Class<S>?): S {
        if (retrofit == null) {
            retrofit = buildRetrofit()
        }
        return retrofit!!.create(serviceClass)
    }

    private fun addStethoInterceptor(client: OkHttpClient.Builder?) {
        val stethoInterceptor = StethoInterceptor()
        for (interceptor in client!!.interceptors()) {
            if (interceptor is StethoInterceptor) {
                return
            }
        }
        client!!.addNetworkInterceptor(stethoInterceptor)
    }

}
