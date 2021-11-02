package com.a_ches.buttoncounterapp.presenter.users

import com.a_ches.buttoncounterapp.presenter.IListPresenter

interface IUserListPresenter : IListPresenter<IUserItemView>
//отвечает за презентер всего списка IListPresenter
//наследуется от UserItemView где есть функция fun setLogin