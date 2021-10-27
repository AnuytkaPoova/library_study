package com.a_ches.buttoncounterapp.model

class GithubUsersRepo {
    //репозиторий который типа возвращает лист пользователей
    private val repositories =
        (0..15).map { GithubUser("login user $it") }

    fun getUsers() : List<GithubUser> {
        return repositories
    }
}