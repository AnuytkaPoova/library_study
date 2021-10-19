package com.a_ches.buttoncounterapp

import moxy.MvpPresenter

class MainPresenter (val usersRepo: GithubUsersRepo): MvpPresenter<IMainView>() {


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

    }




