package com.a_ches.buttoncounterapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a_ches.buttoncounterapp.databinding.ItemUserBinding

class UserRVAdapter(val presenter: IUserListPresenter):
    RecyclerView.Adapter<UserRVAdapter.ViewHolderI>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolderI(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        ).apply {
                    itemView.setOnClickListener {
                        presenter.itemClickListener?.invoke(this)}

        }

    override fun getItemCount() = presenter.getCount()
    override fun onBindViewHolder(holder: ViewHolderI, position: Int) =
        presenter.bindView(holder.apply { pos = position })



    inner class ViewHolderI(val vb: ItemUserBinding):
    RecyclerView.ViewHolder(vb.root), IUserItemView {
        override var pos = -1

        override fun setLogin(text: String) = with(vb) {
            tvLogin.text = text
        }



    }

}