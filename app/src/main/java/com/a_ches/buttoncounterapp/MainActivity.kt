package com.a_ches.buttoncounterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.a_ches.buttoncounterapp.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), IMainView {

    private lateinit var vb: ActivityMainBinding
    private val presenter by moxyPresenter {MainPresenter(CounterModel())}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)
        vb.btnCounter1.setOnClickListener {presenter.counterOneClick()}
        vb.btnCounter2.setOnClickListener {presenter.counterTwoClick()}
        vb.btnCounter3.setOnClickListener {presenter.counterTreeClick()}
    }

    override fun setButtonOneText(text: String) {
        vb.btnCounter1.text = text
    }

    override fun setButtonTwoText(text: String) {
        vb.btnCounter2.text = text
    }

    override fun setButtonThreeText(text: String) {
        vb.btnCounter3.text = text
    }

}