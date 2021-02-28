package com.example.photographer.business.datasource.remote

import com.example.photographer.business.apirest.APIService
import com.example.photographer.business.model.Users
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UsersRemoteDataSource @Inject constructor(val apiService: APIService) {

    fun fetchUsers(): Single<Users> {
        return apiService.fetchUsers()
    }
}