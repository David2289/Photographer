package com.example.photographer.business.datasource

import com.example.photographer.business.model.Users
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface APIService {

    @GET("api/photographer/")
    fun fetchUsers(): Single<Users>

}