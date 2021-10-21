package com.a_ches.buttoncounterapp

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter (val usersRepo: GithubUsersRepo, val router: Router): MvpPresenter<UsersView>() {


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
        }

    }

    private fun loadData() {
        //типа сходили на севак
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




