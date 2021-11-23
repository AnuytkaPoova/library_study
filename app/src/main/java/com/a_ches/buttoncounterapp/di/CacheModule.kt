package com.a_ches.buttoncounterapp.di

import com.a_ches.buttoncounterapp.model.room.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun githubRoomUsersCache(db: AppDataBase): IRoomGithubUsersCache = RoomGithubUsersCache(db)

    @Singleton
    @Provides
    fun githubRoomRepositoryCache(db: AppDataBase): IRoomGithubRepositoryCache =
        RoomGithubRepositoryCache(db)
}