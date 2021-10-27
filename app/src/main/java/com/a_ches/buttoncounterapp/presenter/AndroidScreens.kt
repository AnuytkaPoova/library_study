package com.a_ches.buttoncounterapp.presenter

import com.a_ches.buttoncounterapp.model.GithubUser
import com.a_ches.buttoncounterapp.ui.UserFragment
import com.a_ches.buttoncounterapp.ui.UsersFragment

import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    //это может быть и активити и фрагмент
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(user: GithubUser) = FragmentScreen { UserFragment.newInstance(user) }
    }

