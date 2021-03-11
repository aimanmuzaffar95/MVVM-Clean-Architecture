package com.aiman.mvvmcleanarchitecture.di

import androidx.lifecycle.ViewModel
import com.aiman.mvvmcleanarchitecture.MyApplication
import com.aiman.mvvmcleanarchitecture.ui.fragments.PostFragment
import com.aiman.mvvmcleanarchitecture.ui.fragments.UserFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(application: MyApplication)

    fun inject(userFragment: UserFragment)

    fun inject(postFragment: PostFragment)
}