package com.example.biodun.devfinder.features.user.userList.db

import android.util.Log
import com.example.biodun.devfinder.UserListReceivedEvent
import com.example.biodun.devfinder.UserRoomDatabase
import com.example.biodun.devfinder.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

private const val TAG = "RoomUserRepository"

class RoomUserRepository @Inject constructor(
        private val bus: EventBus,
        private val database: UserRoomDatabase
): UserRepository {

    override fun getUsers(): List<User> {
        return database.userListDao()
                .getAllUsers()
    }

    override fun getObservableUser() {
        database.userListDao()
                .getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({handleGetObservableUserSuccess(it)}, {handleGetObservableUserError(it)})
    }

    private fun handleGetObservableUserError(error: Throwable?) {
        Log.e(TAG,"Error getting user from Database: ${error?.message}")
    }

    private fun handleGetObservableUserSuccess(users: List<User>) {
        bus.post(UserListReceivedEvent(users))
    }

    override fun insertUsers(users: List<User>) {
        database.userListDao().insertAllUsers(users)
    }

    override fun updateUsers(users: List<User>) {
        database.userListDao().updateAllUsers(users)
    }
}
