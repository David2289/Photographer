package com.example.photographer.business.datasource.local.androom.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.photographer.business.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getAll(): List<User>

    @Insert
    fun insert(user: User)

}