package com.example.biodun.devfinder.features.user.userList

import com.example.biodun.devfinder.UserListReceivedEvent
import com.example.biodun.devfinder.features.user.UserService
import com.example.biodun.devfinder.model.User
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

class UserListPresenter @Inject constructor(
        private val bus: EventBus,
        private val userService: UserService
) {

    var users: List<User> = emptyList()

    var mvpView: UserListView? = null

    fun attachView(userListView: UserListView) {
        mvpView = userListView
        bus.register(this)
        userService.getUsers()
    }

    fun detachView() {
        mvpView = null
        bus.unregister(this)
    }

    fun cancelNetworkRequest() {
        userService.disposeSubscription()
    }

    fun syncData(searchParam: String) {
        userService.loadUser(searchParam)
    }

    @Subscribe
    fun onUserListReceivedEvent(event: UserListReceivedEvent) {
        mvpView?.configureRecyclerView(event.users)
    }
}