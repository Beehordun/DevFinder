package com.example.biodun.devfinder.features.user.userList.db

import com.example.biodun.devfinder.model.User

interface UserRepository {
    fun getUsers(): List<User>
    fun getObservableUser()
    fun insertUsers(users: List<User>)
    fun updateUsers(users: List<User>)
}
