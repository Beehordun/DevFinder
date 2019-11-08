package com.example.biodun.devfinder.di

import android.app.Application
import com.example.biodun.devfinder.DevFinderApplication
import com.example.biodun.devfinder.features.user.UserModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (UserModule::class)],
           dependencies = [(ApiComponent::class)])
interface AppComponent {
    val application: Application

    fun inject(application: DevFinderApplication)

    operator fun plus(activityModule: ActivityModule): ActivityComponent
}