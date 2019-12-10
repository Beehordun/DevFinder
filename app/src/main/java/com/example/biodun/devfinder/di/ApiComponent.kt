package com.example.biodun.devfinder.di

import com.example.biodun.devfinder.api.ApiModule
import com.example.biodun.devfinder.api.DevFinderApi
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Component(modules = [(ApiModule::class)])
interface ApiComponent {

    fun devFinderApi(): DevFinderApi
    fun retrofit(): Retrofit
    fun okHttpClient(): OkHttpClient

    class Initializer private constructor() {

        companion object {
            fun init(baseUrl: String): ApiComponent {

                return DaggerApiComponent.builder()
                        .apiModule(ApiModule(baseUrl))
                        .build()
            }
        }
    }

}
