package com.a_ches.buttoncounterapp.model.githubusers

import com.a_ches.buttoncounterapp.presenter.users.IGithubUsersRepo
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GithubUsersRepo(private val api: IGithub) : IGithubUsersRepo {

    override fun getUsers(): Single<List<GithubUser>> = api.getUsers().subscribeOn(Schedulers.io())
}