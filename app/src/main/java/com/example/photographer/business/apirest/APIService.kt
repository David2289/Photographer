package com.example.photographer.business.apirest

import com.example.photographer.business.model.Users
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIService {

    @Headers("Content-Type: application/json")
    @GET("api/photographer/")
    fun fetchUsers(): Single<Users>

    @Headers("Content-Type: application/json")
    @GET("api/photographer/")
    fun fetchUsersCall(): Call<Users>

}