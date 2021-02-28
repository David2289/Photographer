package com.example.photographer.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.photographer.business.repository.UsersRepository

class ListViewModel : ViewModel() {

    val repository: UsersRepository? = null

    fun getUsers() {
        repository?.getUsers()
    }
}