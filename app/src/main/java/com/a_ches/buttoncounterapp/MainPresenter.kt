package com.a_ches.buttoncounterapp

class MainPresenter (private  val view: IMainView) {

    private val model = CounterModel()

    fun counterClick(type: CounterType) {
        when (type) {
            CounterType.FIRST -> {
                val nextValue = model.next(0)
                view.setButtonText(0, nextValue.toString())
            }
            CounterType.SECOND -> {
                val nextValue = model.next(1)
                view.setButtonText(1, nextValue.toString())
            }
            CounterType.THIRD -> {
                val nextValue = model.next(2)
                view.setButtonText(2, nextValue.toString())
            }
        }
    }
}

enum class CounterType {
    FIRST, SECOND, THIRD

}
