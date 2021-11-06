package com.a_ches.buttoncounterapp.presenter.user

import com.a_ches.buttoncounterapp.model.githubusers.GithubRepository
import com.a_ches.buttoncounterapp.model.githubusers.GithubUser
import com.a_ches.buttoncounterapp.model.githubusers.IGithubRepositoriesRepo
import com.a_ches.buttoncounterapp.presenter.IScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter

class UserPresenter(
    private val user: GithubUser,
    private val uiScheduler: Scheduler,
    private val repositoriesRepo: IGithubRepositoriesRepo,
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<IUserView>() {

    class RepoListPresenter : IRepoListPresenter {

        val githubRepository: MutableList<GithubRepository> = mutableListOf()

        override var itemClickListener: ((IRepoItemView) -> Unit)? = null

        override fun bindView(view: IRepoItemView) {
            val repo = githubRepository[view.pos]
            view.setData(repo)
        }

        override fun getCount(): Int = githubRepository.size
    }

    val repoListPresenter = RepoListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        viewState.setLogin(user.login ?: "")
        loadData()

        repoListPresenter.itemClickListener = { itemView ->
            repoListPresenter.githubRepository[itemView.pos]
                .let { screens.repositories(it) }
                .also { router.navigateTo(it) }
        }

    }

    private fun loadData() {
        repositoriesRepo
            .getRepositories(user)
            .observeOn(uiScheduler)
            .subscribe({
                repoListPresenter.githubRepository.clear()
                repoListPresenter.githubRepository.addAll(it)
                viewState.updateListOfRepositories()
            }, {
                viewState.alertMessage(it.message ?: "unknown error")
            })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}