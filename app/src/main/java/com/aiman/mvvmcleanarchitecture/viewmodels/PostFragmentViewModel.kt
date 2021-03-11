package com.aiman.mvvmcleanarchitecture.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aiman.mvvmcleanarchitecture.api.ApiResponse
import com.aiman.mvvmcleanarchitecture.api.Repository
import com.aiman.mvvmcleanarchitecture.models.PostsModel
import com.aiman.mvvmcleanarchitecture.models.UsersModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostFragmentViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val disposables = CompositeDisposable()
    private val postsResponseLiveData = MutableLiveData<ApiResponse<ArrayList<PostsModel>>>()

    fun getPostsResponseLiveData(): MutableLiveData<ApiResponse<ArrayList<PostsModel>>> {
        return postsResponseLiveData
    }

    fun hitGetPosts() {
        disposables.add(repository.executeGetPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { postsResponseLiveData.setValue(ApiResponse.loading()) }
            .subscribe(
                { result -> postsResponseLiveData.setValue(ApiResponse.success(result)) },
                { throwable -> postsResponseLiveData.setValue(ApiResponse.error(throwable)) }
            ))
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

}