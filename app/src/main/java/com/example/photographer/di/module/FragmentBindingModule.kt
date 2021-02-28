package com.example.photographer.di.module

import com.example.photographer.ui.fragment.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector(modules = arrayOf(ViewModelModule::class))
    abstract fun bindListFragment(): ListFragment

}