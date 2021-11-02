package com.a_ches.buttoncounterapp.ui

import android.os.Bundle
import com.a_ches.buttoncounterapp.*
import com.a_ches.buttoncounterapp.databinding.ActivityMainBinding
import com.a_ches.buttoncounterapp.presenter.*
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), IMainView {

    private val navigation = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter {
        ScreenPresenter(
            App.instance.router,
            AndroidScreens()
        )
    }

    private val vb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigationHolder.setNavigator(navigation)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigationHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is IBackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }
}