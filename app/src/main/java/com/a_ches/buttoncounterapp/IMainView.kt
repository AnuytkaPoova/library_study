package com.a_ches.buttoncounterapp

import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle


@StateStrategyType(AddToEndSingleStrategy::class)
interface IMainView :MvpView{ //

    //fun init()
    //fun updateList()


}

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView : MvpView {
    fun init()
    fun updateList()
}





