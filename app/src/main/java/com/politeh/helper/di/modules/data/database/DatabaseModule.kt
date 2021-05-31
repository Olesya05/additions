package com.politeh.helper.di.modules.data.database

import android.content.Context
import androidx.room.Room
import com.politeh.helper.database.HelperDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
    DaosModule::class
])
object DatabaseModule {


    @Singleton
    @Provides
    fun provideRoomDatabase(
        context: Context
    ): HelperDatabase {
        return Room.databaseBuilder(
            context,
            HelperDatabase::class.java,
            HelperDatabase.NAME
        ).apply {
            this.allowMainThreadQueries()
            this.fallbackToDestructiveMigration()
        }.build()
    }


}