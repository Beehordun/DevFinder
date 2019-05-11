package com.example.biodun.lagosjavacoders.features.userList.db

import androidx.room.Dao
import androidx.room.Query
import com.example.biodun.lagosjavacoders.model.User
import com.example.biodun.lagosjavacoders.utils.Constants.USER_TABLE

@Dao
interface UserListDao {

    @Query("SELECT * FROM $USER_TABLE")
    fun getAllUsers(): List<User>
}