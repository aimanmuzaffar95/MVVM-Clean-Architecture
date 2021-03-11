package com.aiman.mvvmcleanarchitecture.api

import com.aiman.mvvmcleanarchitecture.models.PostsModel
import com.aiman.mvvmcleanarchitecture.models.UsersModel
import io.reactivex.Observable

class Repository(private val apiCallInterface: ApiCallInterface) {

    fun executeGetUsers(): Observable<ArrayList<UsersModel>> {
        return apiCallInterface.getUsers()
    }

    fun executeGetPosts(): Observable<ArrayList<PostsModel>> {
        return apiCallInterface.getPosts()
    }

}