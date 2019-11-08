package com.example.biodun.devfinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.biodun.devfinder.di.ActivityComponent
import com.example.biodun.devfinder.di.AppComponent

abstract class BaseActivity: AppCompatActivity() {

    protected val appComponent: AppComponent
        get() = (application as DevFinderApplication).appComponent

    var activityComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        performInjection()

        super.onCreate(savedInstanceState)
    }

    protected abstract fun performInjection()
}