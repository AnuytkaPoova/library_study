package com.a_ches.buttoncounterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.a_ches.buttoncounterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IMainView {

    private lateinit var mainBinding: ActivityMainBinding

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val listener = View.OnClickListener {
            val type = when(it.id) {
                R.id.btn_counter_1 -> CounterType.FIRST
                R.id.btn_counter_2 -> CounterType.SECOND
                R.id.btn_counter_3 -> CounterType.THIRD
                else -> throw IllegalAccessException("такой кнопки нет")
            }
            presenter.counterClick(type)
        }
        mainBinding.btnCounter1.setOnClickListener(listener)
        mainBinding.btnCounter2.setOnClickListener(listener)
        mainBinding.btnCounter3.setOnClickListener(listener)
    }

    override fun setButtonText(index: Int, text: String) {
        when (index) {
            0 -> mainBinding.btnCounter1.text = text
            1 -> mainBinding.btnCounter2.text = text
            3 -> mainBinding.btnCounter3.text = text
        }
    }
}