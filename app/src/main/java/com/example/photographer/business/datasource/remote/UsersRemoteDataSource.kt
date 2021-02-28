package com.example.photographer.business.datasource.remote

import com.example.photographer.business.datasource.APIService
import com.example.photographer.business.model.Users
import io.reactivex.rxjava3.core.Single

class UsersRemoteDataSource constructor(val apiService: APIService) {

    fun fetchUsers(): Single<Users> {
        return apiService.fetchUsers()
    }
}