package com.example.biodun.lagosjavacoders

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.biodun.lagosjavacoders.features.userList.db.UserListDao
import com.example.biodun.lagosjavacoders.model.User
import com.example.biodun.lagosjavacoders.utils.Constants.DATABASE_VERSION

@Database(entities = arrayOf(User::class), version = DATABASE_VERSION)
abstract class UserRoomDatabase: RoomDatabase() {
    abstract fun userListDao(): UserListDao
}