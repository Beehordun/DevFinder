package com.example.biodun.lagosjavacoders.di

import com.example.biodun.lagosjavacoders.features.UserActivity
import dagger.Subcomponent

@Subcomponent(modules = [(ActivityModule::class)])
interface ActivityComponent {

    fun inject(userActivity: UserActivity)
}