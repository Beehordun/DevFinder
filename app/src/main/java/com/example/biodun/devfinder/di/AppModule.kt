package com.example.biodun.devfinder.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.biodun.devfinder.UserRoomDatabase
import com.example.biodun.devfinder.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import org.greenrobot.eventbus.EventBus
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    internal fun provideApplication(): Application {
        return application
    }

    @AppContext
    @Provides
    internal fun provideContext(): Context {
        return this.application.applicationContext
    }

    @Singleton
    @Provides
    internal fun provideBus(): EventBus {
        return EventBus()
    }

    @Singleton
    @Provides
    internal fun provideRoomDatabase(): UserRoomDatabase{
        return Room.databaseBuilder(provideContext(),
                UserRoomDatabase::class.java,
                DATABASE_NAME).build()
    }
}
