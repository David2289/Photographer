package com.example.photographer.business.repository

import com.example.photographer.business.datasource.local.UsersLocalDataSource
import com.example.photographer.business.datasource.remote.UsersRemoteDataSource
import com.example.photographer.business.model.Users
import io.reactivex.rxjava3.core.Single

class UsersRepository constructor(val localDataSource: UsersLocalDataSource, val remoteDataSource: UsersRemoteDataSource) {

    fun getUsers(): Single<Users> {
        return remoteDataSource.fetchUsers()
    }

}