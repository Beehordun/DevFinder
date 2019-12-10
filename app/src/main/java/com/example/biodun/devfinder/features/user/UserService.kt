package com.example.biodun.devfinder.features.user

import android.util.Log
import com.example.biodun.devfinder.api.DevFinderApi
import com.example.biodun.devfinder.features.user.userList.db.UserRepository
import com.example.biodun.devfinder.model.UserList
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserService @Inject constructor(
        private val userRepository: UserRepository,
        private val devFinderApi: DevFinderApi
) {
    private var networkRequestDisposable: Disposable? = null

    fun getUsers() {
        userRepository.getObservableUser()
    }

    fun loadUser(searchParam: String) {
        networkRequestDisposable = devFinderApi.getUsers(searchParam)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe({handleLoadUserSuccessful(it)}, {handleLoadUserError(it)})
    }

    private fun handleLoadUserSuccessful(users: UserList) {
        if (isDatabaseEmpty()) {
            userRepository.insertUsers(users.users)
        } else {
            userRepository.updateUsers(users.users)
        }
    }

    private fun handleLoadUserError(error: Throwable) {
        Log.e("Error", error.message)
    }

    fun disposeSubscription() {
        networkRequestDisposable?.dispose()
    }

    private fun isDatabaseEmpty(): Boolean {
        return userRepository.getUsers().isEmpty()
    }
}
