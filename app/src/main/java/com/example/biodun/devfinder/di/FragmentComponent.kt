package com.example.biodun.devfinder.di

import com.example.biodun.devfinder.features.user.userDetail.UserDetailFragment
import com.example.biodun.devfinder.features.user.userList.UserListFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [(FragmentModule::class)])
interface FragmentComponent {

    fun inject(userListFragment: UserListFragment)
    fun inject(userDetailFragment: UserDetailFragment)
}
