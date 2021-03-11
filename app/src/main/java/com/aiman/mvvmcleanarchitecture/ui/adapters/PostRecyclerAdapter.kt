package com.aiman.mvvmcleanarchitecture.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aiman.mvvmcleanarchitecture.R
import com.aiman.mvvmcleanarchitecture.databinding.ItemPostBinding
import com.aiman.mvvmcleanarchitecture.models.PostsModel

class PostRecyclerAdapter(
    private var list: ArrayList<PostsModel>
): RecyclerView.Adapter<PostRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPostBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_post,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.post = list[position]
        holder.binding.executePendingBindings()
    }

    fun updateList(newList: ArrayList<PostsModel>) {
        this.list = newList
        notifyDataSetChanged()
    }

}