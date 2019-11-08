package com.example.biodun.devfinder.api

import com.example.biodun.devfinder.model.UserList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface DevFinderApi {

    @GET("/search/users")
    fun getUsers(@Query("q") locationAndLanguage: String): Observable<UserList>
}