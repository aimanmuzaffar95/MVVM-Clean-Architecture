package com.aiman.mvvmcleanarchitecture.api

import com.aiman.mvvmcleanarchitecture.models.UsersModel
import io.reactivex.Observable

class Repository(private val apiCallInterface: ApiCallInterface) {
    fun executeGetUsers(): Observable<ArrayList<UsersModel>> {
        return apiCallInterface.getUsers()
    }
}