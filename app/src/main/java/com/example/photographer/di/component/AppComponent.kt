package com.example.photographer.di.component

import android.app.Application
import com.example.photographer.MyApplication
import com.example.photographer.di.module.FragmentBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = arrayOf(
    FragmentBindingModule::class,
    AndroidSupportInjectionModule::class
))
interface AppComponent: AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

}