package com.example.biodun.devfinder

import android.app.Application
import com.example.biodun.devfinder.di.ApiComponent
import com.example.biodun.devfinder.di.AppComponent
import com.example.biodun.devfinder.di.AppModule
import com.example.biodun.devfinder.di.DaggerAppComponent
import com.example.biodun.devfinder.features.user.UserModule

class DevFinderApplication : Application() {
    //To be replaced with BuildConfig
    val BASE_URL = "https://api.github.com"

    val appComponent: AppComponent
        get() = staticAppComponent

    private val appModule: AppModule
        get() = AppModule(this)

    private val userModule: UserModule
        get() = UserModule()

    override fun onCreate() {
        super.onCreate()
        initComponent()
    }

    private fun initComponent() {
        staticAppComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .userModule(userModule)
                .apiComponent(ApiComponent.Initializer.init(BASE_URL))
                .build()

        staticAppComponent.inject(this)
    }

    companion object {

        @JvmStatic lateinit var staticAppComponent: AppComponent
    }
}