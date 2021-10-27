package com.a_ches.buttoncounterapp.presenter

import com.a_ches.buttoncounterapp.model.GithubUser
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter (val user: GithubUser, private val router: Router) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun backPressed(): Boolean {
        router.backTo(null)
        return true
    }
}