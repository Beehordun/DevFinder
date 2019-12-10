package com.example.biodun.devfinder.features.user.userList

import com.example.biodun.devfinder.model.User

interface UserListView {
    fun configureRecyclerView(users: List<User>)
    fun goToUserDetailScreen(user: User)
}
