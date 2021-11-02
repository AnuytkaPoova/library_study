package com.a_ches.buttoncounterapp.ui.users

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.a_ches.buttoncounterapp.App
import com.a_ches.buttoncounterapp.R
import com.a_ches.buttoncounterapp.databinding.FragmentUsersBinding
import com.a_ches.buttoncounterapp.model.githubusers.ApiHolder
import com.a_ches.buttoncounterapp.model.githubusers.GithubUsersRepo
import com.a_ches.buttoncounterapp.presenter.users.IUsersView
import com.a_ches.buttoncounterapp.presenter.users.UsersPresenter
import com.a_ches.buttoncounterapp.ui.AndroidScreens
import com.a_ches.buttoncounterapp.ui.GlideImageLoader
import com.a_ches.buttoncounterapp.ui.IBackButtonListener
import com.google.android.material.snackbar.Snackbar
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), IUsersView, IBackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }

    val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            AndroidSchedulers.mainThread(),
            GithubUsersRepo(ApiHolder.api),
            App.instance.router,
            AndroidScreens()
        )
    }
    private val adapter: UsersRVAdapter by lazy {
        UsersRVAdapter(presenter.usersListPresenter, GlideImageLoader())
    }

    private var vb: FragmentUsersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentUsersBinding.inflate(inflater, container, false)
        .also { vb = it }
        .root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.apply {
            rvUsers.layoutManager = LinearLayoutManager(context)
            rvUsers.adapter = adapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun notifyItemInserted(position: Int) {
        adapter.notifyItemInserted(position)
    }

    override fun showMessageError(message: String) {
        view?.let {
            Snackbar
                .make(it, message, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.reload) {
                    presenter.loadData()
                }
                .show()
        }
    }

    override fun showMessageOnComplete() {
        Toast.makeText(context, "on complete", Toast.LENGTH_LONG).show()
    }

    override fun backPressed(): Boolean = presenter.backPressed()
}