package com.example.photographer.business.datasource.local

import com.example.photographer.business.utility.mapper.ModelMapper
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults
import javax.inject.Inject

class UsersLocalDataSource @Inject constructor() {

    val config = RealmConfiguration.Builder()
        .allowWritesOnUiThread(true)
        .build()
    val backgroundRealm: Realm = Realm.getInstance(config)

    fun saveUser(userRealm: UserRealm) {
        backgroundRealm.executeTransactionAsync { transactionRealm ->
            transactionRealm.insert(userRealm)
        }
    }

    fun getUsers(): RealmResults<UserRealm> {
        return backgroundRealm.where(UserRealm::class.java).findAll()
    }

}