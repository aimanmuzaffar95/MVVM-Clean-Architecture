package com.aiman.mvvmcleanarchitecture.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aiman.mvvmcleanarchitecture.R
import com.aiman.mvvmcleanarchitecture.databinding.ItemCommentBinding
import com.aiman.mvvmcleanarchitecture.models.CommentsModel

class CommentRecyclerAdapter(
    private var list: ArrayList<CommentsModel>
): RecyclerView.Adapter<CommentRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCommentBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCommentBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_comment,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.comment = list[position]
        holder.binding.executePendingBindings()
    }

    fun updateList(newList: ArrayList<CommentsModel>) {
        this.list = newList
        notifyDataSetChanged()
    }
}