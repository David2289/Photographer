package com.example.photographer.business.repository

import com.example.photographer.business.datasource.local.UserRealm
import com.example.photographer.business.datasource.local.UsersLocalDataSource
import com.example.photographer.business.datasource.remote.UsersRemoteDataSource
import com.example.photographer.business.model.User
import com.example.photographer.business.model.Users
import com.example.photographer.business.utility.mapper.ModelMapper
import io.reactivex.rxjava3.core.Single
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults
import javax.inject.Inject

class UsersRepository @Inject constructor(val localDataSource: UsersLocalDataSource, val remoteDataSource: UsersRemoteDataSource) {



    fun getUsers(): Single<Users> {

        if (!localDataSource.getUsers().isEmpty()) {
            val userList: ArrayList<User> = ArrayList()
            val usersRealm: RealmResults<UserRealm> = localDataSource.getUsers()
            for (i in 0 until localDataSource.getUsers().size) {
                usersRealm.get(i)?.let {
                    val user = ModelMapper.getUser(it)
                    userList.add(user)
                }
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
//        for (i in 0 until users.results.size) {
//            val userRealm = ModelMapper.getUserRealm(users.results.get(i))
//            localDataSource.saveUser(userRealm)
//        }
    }

}