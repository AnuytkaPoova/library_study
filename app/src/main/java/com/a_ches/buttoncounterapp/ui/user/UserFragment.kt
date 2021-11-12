package com.a_ches.buttoncounterapp.ui.user

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.a_ches.buttoncounterapp.*
import com.a_ches.buttoncounterapp.databinding.FragmentUserBinding
import com.a_ches.buttoncounterapp.model.AndroidNetworkStatus
import com.a_ches.buttoncounterapp.model.githubusers.GithubRepositoriesRepo
import com.a_ches.buttoncounterapp.model.githubusers.GithubUser
import com.a_ches.buttoncounterapp.model.room.AppDataBase
import com.a_ches.buttoncounterapp.model.room.RoomGithubRepositoryCache
import com.a_ches.buttoncounterapp.presenter.user.IUserView
import com.a_ches.buttoncounterapp.presenter.user.UserPresenter
import com.a_ches.buttoncounterapp.ui.AndroidScreens
import com.a_ches.buttoncounterapp.ui.IBackButtonListener
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), IUserView, IBackButtonListener {

    private val presenter by moxyPresenter {
        UserPresenter(
            requireNotNull(arguments?.getParcelable(KEY_ARG_USER)),
        ).apply { App.instance.appComponent.inject(this) }
    }

    private var binding: FragmentUserBinding? = null

    private val adapter: RepoRVAdapter by lazy {
        RepoRVAdapter(presenter.repoListPresenter)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun init() {
        binding?.run {
            repoList.layoutManager = LinearLayoutManager(context)
            repoList.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun setLogin(login: String) {
        binding?.run {
            userLogin.text = login
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateListOfRepositories() {
        adapter.notifyDataSetChanged()
    }

    override fun alertMessage(message: String) {
        AlertDialog.Builder(context)
            .setMessage(message)
            .create()
            .show()
    }

    override fun backPressed(): Boolean = presenter.backPressed()

    companion object {

        private const val KEY_ARG_USER = "KEY_ARG_USER"

        fun newInstance(user: GithubUser) = UserFragment().apply {
            Bundle().apply {
                putParcelable(KEY_ARG_USER, user)
            }.also {
                arguments = it
            }
        }
    }
}