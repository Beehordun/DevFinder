package com.example.biodun.devfinder.features.user


import android.os.Bundle
import com.example.biodun.devfinder.BaseActivity
import com.example.biodun.devfinder.R
import com.example.biodun.devfinder.di.ActivityModule

class UserActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
    }

    override fun performInjection() {
        activityComponent = appComponent.plus(ActivityModule(this))
        activityComponent?.inject(this)
    }

    override fun onDestroy() {
        activityComponent = null
        super.onDestroy()
    }
}
