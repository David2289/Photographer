package com.example.photographer.business.utility.mapper

import com.example.photographer.business.datasource.local.UserRealm
import com.example.photographer.business.model.User

class ModelMapper {

    companion object {
        fun getUserRealm(user: User): UserRealm {
            return UserRealm(user.id, user.guid, user.email, user.firstName, user.lastName, user.isRemoved,
                user.description, user.avatar, user.image, user.facebook, user.instagram, user.webpage)
        }

        fun getUser(userRealm: UserRealm): User {
            return User(userRealm.id, userRealm.guid, userRealm.email, userRealm.firstName, userRealm.lastName,
                userRealm.isRemoved, userRealm.description, userRealm.avatar, userRealm.image, userRealm.facebook,
                userRealm.instagram, userRealm.webpage)
        }
    }

}