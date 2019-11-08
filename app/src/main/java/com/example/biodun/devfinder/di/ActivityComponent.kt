package com.example.biodun.devfinder.di

import com.example.biodun.devfinder.features.user.UserActivity
import dagger.Subcomponent

@Subcomponent(modules = [(ActivityModule::class)])
interface ActivityComponent {

    fun inject(userActivity: UserActivity)
    operator fun plus(module: FragmentModule): FragmentComponent
}
