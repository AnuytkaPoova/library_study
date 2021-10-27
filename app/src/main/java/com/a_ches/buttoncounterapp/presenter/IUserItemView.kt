package com.a_ches.buttoncounterapp.presenter

import com.a_ches.buttoncounterapp.presenter.IItemView

interface IUserItemView: IItemView {
    //интерфейс только для пользователя
    fun setLogin(text: String)
}