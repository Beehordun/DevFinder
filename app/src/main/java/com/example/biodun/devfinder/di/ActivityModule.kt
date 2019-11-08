package com.example.biodun.devfinder.di

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @ActivityScope
    @Provides
    fun provideActivity(): Activity = this.activity

    @ActivityScope
    @ActivityContext
    @Provides
    fun provideContext(): Context = this.activity
}