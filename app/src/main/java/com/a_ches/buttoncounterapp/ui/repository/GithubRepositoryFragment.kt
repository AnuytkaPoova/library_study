package com.a_ches.buttoncounterapp.ui.repository

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.a_ches.buttoncounterapp.App
import com.a_ches.buttoncounterapp.databinding.FragmentGithubRepositoryBinding
import com.a_ches.buttoncounterapp.model.githubusers.GithubRepository
import com.a_ches.buttoncounterapp.presenter.repository.IRepositoryView
import com.a_ches.buttoncounterapp.presenter.repository.RepositoryPresenter
import com.a_ches.buttoncounterapp.ui.IBackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class GithubRepositoryFragment : MvpAppCompatFragment(), IRepositoryView, IBackButtonListener {

    companion object {

        private const val KEY_DATA = "GithubRepositoryFragment_KEY_DATA"

        fun newInstance(githubRepository: GithubRepository): GithubRepositoryFragment =
            GithubRepositoryFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_DATA, githubRepository)
                }
            }
    }

    private val presenter: RepositoryPresenter by moxyPresenter {
        RepositoryPresenter(
            requireNotNull(arguments?.getParcelable(KEY_DATA)),
            App.instance.router
        )
    }

    private var binding: FragmentGithubRepositoryBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentGithubRepositoryBinding.inflate(inflater, container, false)
        .also {
            binding = it
        }
        .root

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun init(githubRepository: GithubRepository) {
        binding?.run {
            valueName.text = githubRepository.name
            valueFullName.text = githubRepository.fullName
            valueForksCount.text = githubRepository.forksCount.toString()
            valueLanguage.text = githubRepository.language
            valueHtmlUrl.text = githubRepository.htmlUrl
            valueHtmlUrl.paintFlags = valueHtmlUrl.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            valueHtmlUrl.setOnClickListener {
                Intent(Intent.ACTION_VIEW, Uri.parse(githubRepository.htmlUrl)).run {
                    startActivity(this)
                }
            }
        }
    }

    override fun backPressed(): Boolean = presenter.backPressed()
}