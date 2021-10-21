package com.a_ches.buttoncounterapp

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    //это может быть и активити и фрагмент
    override fun users(): Screen {
        return FragmentScreen {
            UsersFragment.newInstance()
        }
    }

}