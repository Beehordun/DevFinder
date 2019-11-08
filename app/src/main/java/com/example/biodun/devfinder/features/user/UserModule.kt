package com.example.biodun.devfinder.features.user

import com.example.biodun.devfinder.UserRoomDatabase
import com.example.biodun.devfinder.api.DevFinderApi
import com.example.biodun.devfinder.features.user.userList.db.RoomUserRepository
import com.example.biodun.devfinder.features.user.userList.db.UserRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable
import org.greenrobot.eventbus.EventBus

@Module
class UserModule {

    @Provides
    @Reusable
    fun provideUserRepository(bus: EventBus, database: UserRoomDatabase): UserRepository {
        return RoomUserRepository(bus, database)
    }

    @Provides
    @Reusable
    fun provideUserService(userRepository: UserRepository, devFinderApi: DevFinderApi): UserService {
        return UserService(userRepository, devFinderApi)
    }
}