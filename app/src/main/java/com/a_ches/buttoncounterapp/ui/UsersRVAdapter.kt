package com.a_ches.buttoncounterapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a_ches.buttoncounterapp.presenter.IUserItemView
import com.a_ches.buttoncounterapp.presenter.IUserListPresenter
import com.a_ches.buttoncounterapp.databinding.ItemUserBinding

class UsersRVAdapter(private val presenter: IUserListPresenter) :
    RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersRVAdapter.ViewHolder =
        ViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }

    override fun onBindViewHolder(holder: UsersRVAdapter.ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    override fun getItemCount(): Int = presenter.getCount()

    inner class ViewHolder(private val vb: ItemUserBinding) : RecyclerView.ViewHolder(vb.root),
        IUserItemView {

        override var pos: Int = -1

        override fun setLogin(text: String) = with(vb) {
            tvLogin.text = text
        }
    }

}