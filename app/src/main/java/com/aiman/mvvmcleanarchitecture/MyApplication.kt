package com.aiman.mvvmcleanarchitecture

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.aiman.mvvmcleanarchitecture.di.AppComponent
import com.aiman.mvvmcleanarchitecture.di.AppModule
import com.aiman.mvvmcleanarchitecture.di.DaggerAppComponent


class MyApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule()).build()
        appComponent.inject(this)
        context = this
    }

    companion object {

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        fun getAppComponent(context: Context): AppComponent {
            return (context.applicationContext as MyApplication).appComponent
        }

        fun getAppContext(): Context {
            return this.context
        }
    }
}