package com.a_ches.buttoncounterapp

interface IUserListPresenter : IListPresenter<IUserItemView>
//отвечает за презентер всего списка IListPresenter
//наследуется от UserItemView где есть функция fun setLogin