package com.a_ches.buttoncounterapp.di

import androidx.room.Room
import com.a_ches.buttoncounterapp.App
import com.a_ches.buttoncounterapp.model.room.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    companion object {
        private const val DB_NAME = "database.db"
    }

    @Singleton
    @Provides
    fun getDatabase(context: App): AppDataBase =
        Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
}