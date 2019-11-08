package com.example.biodun.devfinder

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.biodun.devfinder.features.user.userList.db.UserDao
import com.example.biodun.devfinder.model.User
import com.example.biodun.devfinder.utils.Constants.DATABASE_VERSION

@Database(entities = [User::class], version = DATABASE_VERSION)
abstract class UserRoomDatabase: RoomDatabase() {
    abstract fun userListDao(): UserDao
}