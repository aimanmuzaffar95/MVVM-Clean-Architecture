package com.aiman.mvvmcleanarchitecture.binding.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aiman.mvvmcleanarchitecture.models.UsersModel
import com.aiman.mvvmcleanarchitecture.ui.adapters.UserRecyclerAdapter


object UsersBinding {

    @JvmStatic
    @BindingAdapter(value = ["list"], requireAll = true)
    fun bindUsersRecycler(recyclerView: RecyclerView, list: ArrayList<UsersModel>?) {

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
            recyclerView.adapter = UserRecyclerAdapter(list, recyclerView.context)
        } else {
            (recyclerView.adapter as UserRecyclerAdapter).updateList(list)
        }
    }

}