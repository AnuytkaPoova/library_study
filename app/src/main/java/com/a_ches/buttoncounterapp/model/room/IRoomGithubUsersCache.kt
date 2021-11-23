package com.a_ches.buttoncounterapp.model.room

import com.a_ches.buttoncounterapp.model.githubusers.GithubUser

interface IRoomGithubUsersCache {
    fun save(users: List<GithubUser>)
    fun get(): List<GithubUser>
}