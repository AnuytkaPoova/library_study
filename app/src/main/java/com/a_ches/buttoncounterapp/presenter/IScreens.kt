package com.a_ches.buttoncounterapp.presenter

import com.a_ches.buttoncounterapp.model.GithubUser
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun user(user: GithubUser): Screen
}

