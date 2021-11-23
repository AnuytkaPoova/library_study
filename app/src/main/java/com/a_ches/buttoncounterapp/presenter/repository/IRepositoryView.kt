package com.a_ches.buttoncounterapp.presenter.repository

import com.a_ches.buttoncounterapp.model.githubusers.GithubRepository
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(AddToEndSingleStrategy::class)
interface IRepositoryView : MvpView {
    fun init(githubRepository: GithubRepository)
}
