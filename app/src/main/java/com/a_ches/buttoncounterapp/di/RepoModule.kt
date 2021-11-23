package com.a_ches.buttoncounterapp.di

import com.a_ches.buttoncounterapp.model.INetworkStatus
import com.a_ches.buttoncounterapp.model.githubusers.GithubRepositoriesRepo
import com.a_ches.buttoncounterapp.model.githubusers.GithubUsersRepo
import com.a_ches.buttoncounterapp.model.githubusers.IDataSource
import com.a_ches.buttoncounterapp.model.githubusers.IGithubRepositoriesRepo
import com.a_ches.buttoncounterapp.model.room.IRoomGithubRepositoryCache
import com.a_ches.buttoncounterapp.model.room.IRoomGithubUsersCache
import com.a_ches.buttoncounterapp.presenter.users.IGithubUsersRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun githubUsersRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IRoomGithubUsersCache
    ): IGithubUsersRepo = GithubUsersRepo(api, networkStatus, cache)

    @Singleton
    @Provides
    fun githubRepositoriesRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IRoomGithubRepositoryCache
    ): IGithubRepositoriesRepo = GithubRepositoriesRepo(api, networkStatus, cache)
}