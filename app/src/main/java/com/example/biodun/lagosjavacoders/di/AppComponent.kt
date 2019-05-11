package com.example.biodun.lagosjavacoders.di

import android.app.Application
import com.example.biodun.lagosjavacoders.DevFinderApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)],
           dependencies = [(ApiComponent::class)])
interface AppComponent {
    val application: Application

    fun inject(application: DevFinderApplication)

    operator fun plus(activityModule: ActivityModule): ActivityComponent
}