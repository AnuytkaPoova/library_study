package com.a_ches.buttoncounterapp

interface IUserItemView: IItemView {
    //интерфейс только для пользователя
    fun setLogin(text: String)
}