package com.a_ches.buttoncounterapp.model.githubusers

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface IDataSource {
    @GET("users")
    fun getUsers(): Single<List<GithubUser>>

    @GET
    fun getRepos(@Url url: String): Single<List<GithubRepository>>
}