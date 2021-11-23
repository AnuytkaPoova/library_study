package com.a_ches.buttoncounterapp.model.githubusers

import com.a_ches.buttoncounterapp.model.INetworkStatus
import com.a_ches.buttoncounterapp.model.room.IRoomGithubRepositoryCache
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GithubRepositoriesRepo(
    private val api: IDataSource,
    private val networkStatus: INetworkStatus,
    private val cache: IRoomGithubRepositoryCache
) : IGithubRepositoriesRepo {
    override fun getRepositories(user: GithubUser): Single<List<GithubRepository>> =

        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                user.reposUrl?.let { url ->
                    api.getRepos(url)
                        .flatMap { repositories ->
                            Single.fromCallable {
                                cache.save(user, repositories)
                                repositories
                            }
                        }
                        .onErrorReturn {
                            cache.get(user)
                        }
                }
                    ?: Single.error<List<GithubRepository>>(IllegalStateException("User has no repos url"))
                        .subscribeOn(Schedulers.io())
            } else {
                Single.fromCallable { cache.get(user) }
            }
        }
            .subscribeOn(Schedulers.io())
}