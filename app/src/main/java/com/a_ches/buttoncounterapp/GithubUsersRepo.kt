package com.a_ches.buttoncounterapp

class GithubUsersRepo {
    //репозиторий который типа возвращает лист пользователей
    private val repositories =
        (0..15).map { GithubUser("login user $it")}
        /*
        listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5"),
         )
         */


    fun getUsers() : List<GithubUser> {
        return repositories
    }
}