package com.example.biodun.devfinder.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.biodun.devfinder.utils.Constants.USER_TABLE
import com.google.gson.annotations.SerializedName

@Entity(tableName = USER_TABLE)
data class User(

        @PrimaryKey(autoGenerate = true)
        val userId: Int,

        @SerializedName("login")
        val userName: String,

        @SerializedName("avatar_url")
        val avatarUrl: String,

        @SerializedName("html_url")
        val htmlUrl: String
)
