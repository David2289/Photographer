package com.example.photographer.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.photographer.business.model.Users
import com.example.photographer.business.repository.UsersRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ListViewModel @Inject constructor(val repository: UsersRepository) : ViewModel() {

    var usersLiveData: MutableLiveData<Users> = MutableLiveData()

    fun getUsers() {
        repository.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError)
    }

    private fun handleResponse(users: Users) {
        usersLiveData.value = users
    }

    private fun handleError(t: Throwable) {
        Log.w("APICALL_TEST", "HAS BEEN AN ERROR: " + t.message)
    }
}