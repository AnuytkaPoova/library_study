package com.a_ches.buttoncounterapp.presenter

import com.a_ches.buttoncounterapp.model.GithubUser
import com.a_ches.buttoncounterapp.model.GithubUsersRepo
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter (private val usersRepo: GithubUsersRepo, private val router: Router, private val screens: IScreens): MvpPresenter<UsersView>() {

    class UsersListPresenter : IUserListPresenter {

        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((IUserItemView) -> Unit)? = null
        override fun getCount() = users.size
        override fun bindView(view: IUserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }


    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->
            //TODO: gtht: переход на экран пользователя
            screens.user(usersListPresenter.users[itemView.pos])
                .also { router.navigateTo(it) }
        }
    }

    private fun loadData() {
        //типа сходили на сервак
        val users = usersRepo.getUsers()
        //добавляем в наш проект список данные
        usersListPresenter.users.addAll(users)
        //обновляется вьюшка в ресайкле
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}




