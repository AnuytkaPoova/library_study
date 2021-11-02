package com.a_ches.buttoncounterapp.presenter.repository

import com.a_ches.buttoncounterapp.model.githubusers.GithubRepository
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class RepositoryPresenter (
    private val githubRepository: GithubRepository,
    private val router: Router
) : MvpPresenter<IRepositoryView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init(githubRepository)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}