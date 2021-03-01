package com.example.photographer.business.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "user_table")
class User(
        @PrimaryKey
        @ColumnInfo(name = "id")
        @SerializedName("id")
        var id: Int,

        @ColumnInfo(name = "guid")
        @SerializedName("guid")
        var guid: String,

        @ColumnInfo(name = "email")
        @SerializedName("email")
        var email: String,

        @ColumnInfo(name = "first_name")
        @SerializedName("first_name")
        var firstName: String,

        @ColumnInfo(name = "last_name")
        @SerializedName("last_name")
        var lastName: String,

        @ColumnInfo(name = "is_removed")
        @SerializedName("is_removed")
        var isRemoved: Boolean,

        @ColumnInfo(name = "description")
        @SerializedName("description")
        var description: String,

        @ColumnInfo(name = "avatar")
        @SerializedName("avatar")
        var avatar: String?,

        @ColumnInfo(name = "image")
        @SerializedName("image")
        var image: String?,

        @ColumnInfo(name = "facebook")
        @SerializedName("facebook")
        var facebook: String?,

        @ColumnInfo(name = "instagram")
        @SerializedName("instagram")
        var instagram: String?,

        @ColumnInfo(name = "webpage")
        @SerializedName("webpage")
        var webpage: String?

): Serializable