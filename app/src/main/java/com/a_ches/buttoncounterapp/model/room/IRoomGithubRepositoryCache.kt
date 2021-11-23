package com.a_ches.buttoncounterapp.model.room

import com.a_ches.buttoncounterapp.model.githubusers.GithubRepository
import com.a_ches.buttoncounterapp.model.githubusers.GithubUser

interface IRoomGithubRepositoryCache {
    fun save(user: GithubUser, repositories: List<GithubRepository>)
    fun get(user: GithubUser): List<GithubRepository>
}