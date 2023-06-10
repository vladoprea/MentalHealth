package com.hfad.mentalhealth.api

import com.hfad.mentalhealth.model.Names
import com.hfad.mentalhealth.model.UserData
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("v1/sample-data/users?offset=10&limit=7")
    suspend fun getNamesList(): Response<UserData>
}