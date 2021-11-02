package com.a_ches.buttoncounterapp.presenter.users

import com.a_ches.buttoncounterapp.model.githubusers.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
}