package com.example.biodun.devfinder.model

import com.google.gson.annotations.SerializedName

data class UserList(
        @SerializedName("items")
        val users: List<User>
)
