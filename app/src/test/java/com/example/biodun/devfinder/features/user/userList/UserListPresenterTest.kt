package com.example.biodun.devfinder.features.user.userList

import com.example.biodun.devfinder.UserListReceivedEvent
import com.example.biodun.devfinder.features.user.UserService
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.greenrobot.eventbus.EventBus
import org.junit.Assert.assertNull
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class UserListPresenterTest {

    @get:Rule
    var mockitoRule: MockitoRule = MockitoJUnit.rule()

    @InjectMocks lateinit var presenter: UserListPresenter
    @Mock lateinit var userService: UserService
    @Mock lateinit var bus: EventBus
    @Mock private lateinit var userListView: UserListView

    @Test
    fun attachView_should_registerBus() {
        presenter.attachView(userListView)
        verify(bus, times(1)).register(presenter)
    }

    @Test
    fun attachView_should_getUsers() {
        presenter.attachView(userListView)
        verify(userService, times(1)).getUsers()
    }

    @Test
    fun detachView_should_unregisterBus_andSetViewToNull() {
        presenter.detachView()
        assertNull(presenter.mvpView)
        verify(bus, times(1)).unregister(presenter)
    }

    @Test
    fun cancelNetworkSubscriptions_ShouldDisposeSubscriptions() {
        presenter.cancelNetworkSubscriptions()
        verify(userService, times(1)).disposeSubscription()
    }

    @Test
    fun syncData_shouldLoadUser() {
        val searchParam = "test1234"
        presenter.syncData(searchParam)
        verify(userService).loadUser(eq(searchParam))
    }

    @Test
    fun onUserListReceivedEvent_shouldConfigureRecyclerView() {
        val event = UserListReceivedEvent(presenter.users)
        presenter.attachView(userListView)
        presenter.onUserListReceivedEvent(event)
        verify(presenter.mvpView)?.configureRecyclerView(event.users)
    }
}
