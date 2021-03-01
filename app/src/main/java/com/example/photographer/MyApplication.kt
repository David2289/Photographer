package com.example.photographer

import com.example.photographer.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.realm.Realm

class MyApplication: DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}