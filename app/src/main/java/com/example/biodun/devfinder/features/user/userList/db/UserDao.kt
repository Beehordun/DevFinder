package com.example.biodun.devfinder.features.user.userList.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.biodun.devfinder.model.User
import com.example.biodun.devfinder.utils.Constants.USER_TABLE
import io.reactivex.Flowable

@Dao
interface UserDao {

    @Query("SELECT * FROM $USER_TABLE")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM $USER_TABLE")
    fun getUsers(): Flowable<List<User>>

    @Insert
    fun insertAllUsers(users: List<User>)

    @Update
    fun updateAllUsers(users: List<User>)
}
