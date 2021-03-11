package com.aiman.mvvmcleanarchitecture.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aiman.mvvmcleanarchitecture.api.ApiResponse
import com.aiman.mvvmcleanarchitecture.api.Repository
import com.aiman.mvvmcleanarchitecture.models.CommentsModel
import com.aiman.mvvmcleanarchitecture.models.PostsModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CommentsFragmentViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val disposables = CompositeDisposable()
    private val commentsResponseLiveData = MutableLiveData<ApiResponse<ArrayList<CommentsModel>>>()

    fun getCommentsResponseLiveData(): MutableLiveData<ApiResponse<ArrayList<CommentsModel>>> {
        return commentsResponseLiveData
    }

    fun hitGetComments() {
        disposables.add(repository.executeGetComments()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { commentsResponseLiveData.setValue(ApiResponse.loading()) }
            .subscribe(
                { result -> commentsResponseLiveData.setValue(ApiResponse.success(result)) },
                { throwable -> commentsResponseLiveData.setValue(ApiResponse.error(throwable)) }
            ))
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}