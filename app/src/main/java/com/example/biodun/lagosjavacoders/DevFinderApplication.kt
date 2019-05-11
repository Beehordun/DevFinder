package com.example.biodun.lagosjavacoders

import android.app.Application
import com.example.biodun.lagosjavacoders.di.ApiComponent
import com.example.biodun.lagosjavacoders.di.AppComponent
import com.example.biodun.lagosjavacoders.di.AppModule
import com.example.biodun.lagosjavacoders.di.DaggerAppComponent

class DevFinderApplication : Application() {
    //To be replaced with BuildConfig
    val BASE_URL = "https://api.github.com/"

    val appComponent: AppComponent
        get() = staticAppComponent

    internal val appModule: AppModule
        get() = AppModule(this)

    override fun onCreate() {
        super.onCreate()

    }

    fun initComponent() {
        staticAppComponent = DaggerAppComponent.builder().appModule(appModule)
                .apiComponent(ApiComponent.Initializer.init(BASE_URL))
                .build()

        staticAppComponent.inject(this)
    }

    companion object {

        @JvmStatic lateinit var staticAppComponent: AppComponent
    }
}