package com.a_ches.buttoncounterapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.a_ches.buttoncounterapp.App
import com.a_ches.buttoncounterapp.databinding.FragmentUserBinding
import com.a_ches.buttoncounterapp.model.GithubUser
import com.a_ches.buttoncounterapp.presenter.IBackButtonListener
import com.a_ches.buttoncounterapp.presenter.UserPresenter
import com.a_ches.buttoncounterapp.presenter.UserView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), UserView, IBackButtonListener {

    private val presenter by moxyPresenter {
        UserPresenter(requireNotNull(arguments?.getParcelable(KEY_ARG_USER)), App.instance.router)
    }

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserBinding.inflate(inflater, container, false).also {
            _binding = it
        }.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun init() {
        binding.run {
            userLogin.text = presenter.user.login
        }
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