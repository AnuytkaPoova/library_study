package com.a_ches.buttoncounterapp.model.room

import com.a_ches.buttoncounterapp.model.githubusers.GithubRepository
import com.a_ches.buttoncounterapp.model.githubusers.GithubUser

class RoomGithubRepositoryCache (private val db: AppDataBase) : IRoomGithubRepositoryCache {
    override fun save(user: GithubUser, repositories: List<GithubRepository>) {

        val roomUser = user.login?.let {
            db.userDao.findByLogin(it)
        } ?: throw IllegalStateException("No such user in cache")

        val roomRepos = repositories.map {
            RoomGithubRepository(
                it.id ?: "",
                it.name ?: "",
                it.fullName ?: "",
                it.forksCount ?: 0,
                it.language ?: "",
                it.htmlUrl ?: "",
                roomUser.uid
            )
        }
        db.repositoryDao.deleteForUser(roomUser.uid)
        db.repositoryDao.insert(roomRepos)
    }

    override fun get(user: GithubUser): List<GithubRepository> {

        val roomUser = user.login?.let {
            db.userDao.findByLogin(it)
        } ?: throw IllegalStateException("No such user in cache")

        return db.repositoryDao.findForUser(roomUser.uid).map {
            GithubRepository(
                it.uid,
                it.mame,
                it.fullName,
                it.language,
                it.forksCount,
                it.htmlUrl
            )
        }
    }
}