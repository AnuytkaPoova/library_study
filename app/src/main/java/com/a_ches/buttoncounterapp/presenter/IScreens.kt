package com.a_ches.buttoncounterapp.presenter

import com.a_ches.buttoncounterapp.model.githubusers.GithubRepository
import com.a_ches.buttoncounterapp.model.githubusers.GithubUser
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun user(user: GithubUser): Screen
    fun repositories(repository: GithubRepository): Screen
}

