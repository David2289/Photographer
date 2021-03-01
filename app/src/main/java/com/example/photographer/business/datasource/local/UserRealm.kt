package com.example.photographer.business.datasource.local

import androidx.room.PrimaryKey
import io.realm.RealmObject

open class UserRealm(
    @PrimaryKey
    var id: Int = 0,
    var guid: String = "",
    var email: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var isRemoved: Boolean = false,
    var description: String = "",
    var avatar: String? = "",
    var image: String? = "",
    var facebook: String? = "",
    var instagram: String? = "",
    var webpage: String? = ""
): RealmObject()