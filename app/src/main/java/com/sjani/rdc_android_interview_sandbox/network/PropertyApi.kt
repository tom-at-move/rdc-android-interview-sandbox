package com.sjani.rdc_android_interview_sandbox.network

import com.sjani.rdc_android_interview_sandbox.models.PropertyResponse
import retrofit2.Response
import retrofit2.http.GET

const val BASE_URL = "https://mapi-ng.rdc.moveaws.com"

interface PropertyApi {
    @GET("/api/v1/properties?offset=0&limit=20&city=San+Jose&state_code=CA&sort=relevance&client_id=android")
    suspend fun getProperties(): Response<PropertyResponse>
}