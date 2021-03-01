package com.example.photographer.business.repository

import com.example.photographer.business.datasource.local.UsersLocalDataSource
import com.example.photographer.business.datasource.remote.UsersRemoteDataSource
import com.example.photographer.business.model.User
import com.example.photographer.business.model.Users
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UsersRepository @Inject constructor(val localDataSource: UsersLocalDataSource, val remoteDataSource: UsersRemoteDataSource) {

    fun getUsers(): Single<Users> {

        if (!localDataSource.getUsers().isEmpty()) {
            val userList: ArrayList<User> = ArrayList()
            val savedList: List<User> = localDataSource.getUsers()
            for (i in 0 until savedList.size) {
                val user = savedList.get(i)
                userList.add(user)
            }
            val users = Users(17, "", "", userList)
            return Single.just(users)
        }
        else {
            return remoteDataSource.fetchUsers()
                .doOnSuccess(this::saveUsers)
        }
    }

    private fun saveUsers(users: Users) {
        for (i in 0 until users.results.size) {
            val user = users.results.get(i)
            localDataSource.saveUser(user)
        }
    }

}