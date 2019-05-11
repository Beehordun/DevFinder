package com.example.biodun.lagosjavacoders.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.biodun.lagosjavacoders.UserRoomDatabase
import com.example.biodun.lagosjavacoders.utils.Constants.DATABASE_NAME
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
        return application.applicationContext
    }

    @Singleton
    @Provides
    internal fun provideBus(): EventBus {
        return EventBus()
    }

    @Singleton
    @Provides
    internal fun provideRoomDatabase(context: Context): UserRoomDatabase{
        return Room.databaseBuilder(context,
                UserRoomDatabase::class.java,
                DATABASE_NAME).build()
    }
}
