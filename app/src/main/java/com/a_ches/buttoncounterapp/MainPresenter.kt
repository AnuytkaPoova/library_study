package com.a_ches.buttoncounterapp

class MainPresenter (private  val view: IMainView) {

    private val model = CounterModel()

    fun counterClick(type: CounterType) {
        val  nextValue = when (type) {
            CounterType.FIRST ->  model.next(0)
            CounterType.SECOND ->  model.next(1)
            CounterType.THIRD ->  model.next(2)

        }
        view.setButtonText(type, nextValue.toString())
    }
}

enum class CounterType {
    FIRST, SECOND, THIRD

}
