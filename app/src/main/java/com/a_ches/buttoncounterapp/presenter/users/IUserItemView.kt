package com.a_ches.buttoncounterapp.presenter.users

import com.a_ches.buttoncounterapp.presenter.IItemView

interface IUserItemView: IItemView {
    fun setLogin(text: String)
    fun loadAvatar(url: String)
}