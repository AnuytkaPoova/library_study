package com.a_ches.buttoncounterapp.ui

import com.a_ches.buttoncounterapp.model.githubusers.GithubRepository
import com.a_ches.buttoncounterapp.model.githubusers.GithubUser
import com.a_ches.buttoncounterapp.presenter.IScreens
import com.a_ches.buttoncounterapp.ui.repository.GithubRepositoryFragment
import com.a_ches.buttoncounterapp.ui.user.UserFragment
import com.a_ches.buttoncounterapp.ui.users.UsersFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(user: GithubUser) = FragmentScreen { UserFragment.newInstance(user) }
    override fun repositories(repository: GithubRepository): Screen = FragmentScreen {
        GithubRepositoryFragment.newInstance(repository)
    }
}