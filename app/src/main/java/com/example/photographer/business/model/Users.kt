package com.example.photographer.business.model

import com.google.gson.annotations.SerializedName

class Users(
    @SerializedName("count") var count: Int,
    @SerializedName("next") var next: String,
    @SerializedName("previous") var previous: String,
    @SerializedName("results") var results: List<User>,
)