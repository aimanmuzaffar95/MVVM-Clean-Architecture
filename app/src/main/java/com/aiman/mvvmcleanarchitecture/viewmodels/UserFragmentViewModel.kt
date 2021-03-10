package com.aiman.mvvmcleanarchitecture.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aiman.mvvmcleanarchitecture.api.ApiResponse
import com.aiman.mvvmcleanarchitecture.api.Repository
import com.aiman.mvvmcleanarchitecture.models.UsersModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserFragmentViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val disposables = CompositeDisposable()
    private val usersResponseLiveData = MutableLiveData<ApiResponse<ArrayList<UsersModel>>>()

    fun getUsersResponseLiveData(): MutableLiveData<ApiResponse<ArrayList<UsersModel>>> {
        return usersResponseLiveData
    }

    fun hitGetUsersResponseLiveData() {
        disposables.add(repository.executeGetUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { usersResponseLiveData.setValue(ApiResponse.loading()) }
            .subscribe(
                { result -> usersResponseLiveData.setValue(ApiResponse.success(result)) },
                { throwable -> usersResponseLiveData.setValue(ApiResponse.error(throwable)) }
            ))
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}