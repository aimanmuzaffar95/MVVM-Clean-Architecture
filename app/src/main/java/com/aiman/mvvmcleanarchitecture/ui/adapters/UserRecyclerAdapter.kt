package com.aiman.mvvmcleanarchitecture.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aiman.mvvmcleanarchitecture.R
import com.aiman.mvvmcleanarchitecture.databinding.ItemUserBinding
import com.aiman.mvvmcleanarchitecture.models.UsersModel

class UserRecyclerAdapter(
    private var list: ArrayList<UsersModel>
) : RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemUserBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_user,
                parent,
                false
            )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.user = list[position]
        holder.binding.fullAddress = list[position].address.suite +  ", " + list[position].address.street +
                list[position].address.city + ", " + list[position].address.zipcode
        holder.binding.executePendingBindings()
    }

    fun updateList(newList: ArrayList<UsersModel>) {
        this.list = newList
        notifyDataSetChanged()
    }
}