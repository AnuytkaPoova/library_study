package com.a_ches.buttoncounterapp.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a_ches.buttoncounterapp.databinding.ItemRepoBinding
import com.a_ches.buttoncounterapp.model.githubusers.GithubRepository
import com.a_ches.buttoncounterapp.presenter.user.IRepoItemView
import com.a_ches.buttoncounterapp.presenter.user.IRepoListPresenter

class RepoRVAdapter (
    private val presenter: IRepoListPresenter
) : RecyclerView.Adapter<RepoRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemRepoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        ).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    override fun getItemCount(): Int = presenter.getCount()

    inner class ViewHolder(private val binding: ItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root),
        IRepoItemView {

        override var pos: Int = -1

        override fun setData(repository: GithubRepository) {
            with(binding) {
                repoName.text = repository.name
                repoLanguage.text = repository.language
            }
        }
    }
}