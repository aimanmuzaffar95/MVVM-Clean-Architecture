package com.aiman.mvvmcleanarchitecture.api

import com.aiman.mvvmcleanarchitecture.models.UsersModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiCallInterface {
    @GET(Urls.USERS)
    fun getUsers(): Observable<ArrayList<UsersModel>>

}