package com.move.rdc_android_interview_sandbox.data.network

import com.move.rdc_android_interview_sandbox.data.models.PropertiesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

const val BASE_URL = "https://mapi-ng.rdc.moveaws.com"

interface PropertyApi {
    @GET("/api/v1/properties?offset=0&limit=20&city=San+Jose&state_code=CA&sort=relevance&client_id=android")
    @Headers("User-Agent: Hello")
    suspend fun getProperties(): Response<PropertiesResponse>

}