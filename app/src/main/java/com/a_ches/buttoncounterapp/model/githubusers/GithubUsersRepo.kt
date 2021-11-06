package com.a_ches.buttoncounterapp.model.githubusers

import com.a_ches.buttoncounterapp.model.INetworkStatus
import com.a_ches.buttoncounterapp.model.room.IRoomGithubUsersCache
import com.a_ches.buttoncounterapp.presenter.users.IGithubUsersRepo
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GithubUsersRepo(
    private val api: IDataSource,
    private val networkStatus: INetworkStatus,
    private val cache: IRoomGithubUsersCache
) : IGithubUsersRepo {

    override fun getUsers(): Single<List<GithubUser>> =
        networkStatus.isOnlineSingle()
            .flatMap { isOnline ->
                if (isOnline) {
                    api.getUsers()
                        .flatMap { users ->
                            Single.fromCallable {
                                cache.save(users)
                                users
                            }
                        }
                        .onErrorReturn{
                            cache.get()
                        }
                } else {
                    Single.fromCallable { cache.get() }
                }
                    .subscribeOn(Schedulers.io())
            }
}
