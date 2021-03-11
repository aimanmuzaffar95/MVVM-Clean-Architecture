package com.aiman.mvvmcleanarchitecture.binding.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aiman.mvvmcleanarchitecture.models.PostsModel
import com.aiman.mvvmcleanarchitecture.ui.adapters.PostRecyclerAdapter

object PostsBinding {
    @JvmStatic
    @BindingAdapter(value = ["list"], requireAll = true)
    fun bindUsersRecycler(recyclerView: RecyclerView, list: ArrayList<PostsModel>?) {

        if(list == null)
            return

        if(recyclerView.layoutManager == null) {
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.addItemDecoration(
                DividerItemDecoration(
                    recyclerView.context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        if(recyclerView.adapter == null) {
            recyclerView.adapter = PostRecyclerAdapter(list)
        } else {
            (recyclerView.adapter as PostRecyclerAdapter).updateList(list)
        }
    }
}