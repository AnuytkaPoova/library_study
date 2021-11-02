package com.a_ches.buttoncounterapp.presenter.user

import com.a_ches.buttoncounterapp.model.githubusers.GithubRepository
import com.a_ches.buttoncounterapp.presenter.IItemView

interface IRepoItemView : IItemView {
    fun setData(name: GithubRepository)
}