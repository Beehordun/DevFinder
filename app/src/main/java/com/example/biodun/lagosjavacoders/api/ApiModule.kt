package com.example.biodun.lagosjavacoders.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule(private val baseUrl: String) {

    @Provides
    @Reusable
    fun provideOkhttpClient(): OkHttpClient {
        return OkHttpClient()
    }

    @Provides
    @Reusable
    fun provideDevFinderApi(retrofit: Retrofit): DevFinderApi =
            retrofit.create(DevFinderApi::class.java)

    @Provides
    @Reusable
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
        builder.baseUrl(this.baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())

        return builder.build()
    }
}
