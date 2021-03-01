package com.example.photographer.business.datasource.local

import com.example.photographer.business.datasource.local.androom.dao.UserDao
import com.example.photographer.business.model.User
import javax.inject.Inject

class UsersLocalDataSource @Inject constructor(val userDao: UserDao) {

    fun saveUser(user: User) {
        userDao.insert(user)
    }

    fun getUsers(): List<User> {
        return userDao.getAll()
    }

}