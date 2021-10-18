package com.a_ches.buttoncounterapp

import moxy.MvpPresenter

class MainPresenter (val model: CounterModel): MvpPresenter<IMainView>() {

    fun counterOneClick() {
        val nextValue = model.next(0)
        viewState.setButtonOneText(nextValue.toString())
    }
    fun counterTwoClick() {
        val nextValue = model.next(1)
        viewState.setButtonTwoText(nextValue.toString())
    }
    fun counterTreeClick() {
        val nextValue = model.next(2)
        viewState.setButtonThreeText(nextValue.toString())
    }



}
