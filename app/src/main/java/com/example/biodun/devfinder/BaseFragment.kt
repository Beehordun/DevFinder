package com.example.biodun.devfinder

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.biodun.devfinder.di.ActivityComponent
import com.example.biodun.devfinder.di.FragmentComponent

open class BaseFragment: Fragment() {

    protected val activityComponent: ActivityComponent?
        get() = (activity as BaseActivity).activityComponent

    var fragmentComponent: FragmentComponent? = null

    override fun onAttach(context: Context) {
        performInjection()
        super.onAttach(context)
    }

    override fun onDetach() {
        fragmentComponent = null
        super.onDetach()
    }

    protected open fun performInjection() {}
}
