package com.example.photographer.business.model

import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("id")  var id: Int,
    @SerializedName("guid")  var guid: String,
    @SerializedName("email")  var email: String,
    @SerializedName("first_name")  var firstName: String,
    @SerializedName("last_name")  var lastName: String,
    @SerializedName("is_removed")  var isRemoved: Boolean,
    @SerializedName("description")  var description: String,
    @SerializedName("avatar")  var avatar: String?,
    @SerializedName("image")  var image: String?,
    @SerializedName("facebook")  var facebook: String?,
    @SerializedName("instagram")  var instagram: String?,
    @SerializedName("webpage")  var webpage: String?,
)