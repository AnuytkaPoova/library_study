package com.a_ches.buttoncounterapp.presenter

import com.a_ches.buttoncounterapp.presenter.IListPresenter
import com.a_ches.buttoncounterapp.presenter.IUserItemView

interface IUserListPresenter : IListPresenter<IUserItemView>
//отвечает за презентер всего списка IListPresenter
//наследуется от UserItemView где есть функция fun setLogin