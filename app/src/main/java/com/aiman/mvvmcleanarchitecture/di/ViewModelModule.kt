package com.aiman.mvvmcleanarchitecture.di

import androidx.lifecycle.ViewModel
import com.aiman.mvvmcleanarchitecture.viewmodels.CommentsFragmentViewModel
import com.aiman.mvvmcleanarchitecture.viewmodels.PostFragmentViewModel
import com.aiman.mvvmcleanarchitecture.viewmodels.UserFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserFragmentViewModel::class)
    abstract fun bindUserFragmentViewModel(viewModel: UserFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostFragmentViewModel::class)
    abstract fun bindPostFragmentViewModel(viewModel: PostFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CommentsFragmentViewModel::class)
    abstract fun bindCommentFragmentViewModel(viewModel: CommentsFragmentViewModel): ViewModel
}