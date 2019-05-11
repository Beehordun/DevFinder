package com.example.biodun.lagosjavacoders.api

import com.example.biodun.lagosjavacoders.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DevFinderApi {

    @GET("/search/users")
    fun getUsers(
            @Query("location") location: String,
            @Query("language") language: String): Call<List<User>>
}