package com.scorradi.cv.service

import com.scorradi.cv.CvApplication
import com.scorradi.cv.datamanager.Utils
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest

class MockedRetrofitServiceBuilder(var port: Int) : RetrofitServiceBuilder() {
    val mockWebServer: MockWebServer = MockWebServer()

    init {
        setServer("http://127.0.0.1:" + port)
    }

    //gets the filename
    fun setDispatcher(filename: String) {
        mockWebServer.dispatcher = object : Dispatcher() {
            @Throws(InterruptedException::class)
            override fun dispatch(recordedRequest: RecordedRequest): MockResponse {
                val mockResponse = MockResponse()
                mockResponse.setResponseCode(200)
                val fileContent = Utils.loadJsonFromFile(filename, CvApplication.applicationContext())
                return mockResponse.setBody(fileContent)
            }
        }
    }

    //gets a Json
    fun setJsonDispatcher(json: String) {
        mockWebServer.dispatcher = object : Dispatcher() {
            @Throws(InterruptedException::class)
            override fun dispatch(recordedRequest: RecordedRequest): MockResponse {
                val mockResponse = MockResponse()
                mockResponse.setResponseCode(200)
                return mockResponse.setBody(json)
            }
        }
    }

    fun start() {
            mockWebServer.start(port)
    }

    fun shutdown() {
            mockWebServer.shutdown()
    }
}