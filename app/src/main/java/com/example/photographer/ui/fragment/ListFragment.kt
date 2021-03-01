package com.example.photographer.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.photographer.R
import com.example.photographer.business.model.User
import com.example.photographer.business.model.Users
import com.example.photographer.databinding.ListFragmentBinding
import com.example.photographer.ui.adapter.UsersAdapter
import com.example.photographer.ui.utility.helper.Constants
import com.example.photographer.ui.viewmodel.ListViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ListFragment : DaggerFragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: ListViewModel
    lateinit var binding: ListFragmentBinding
    lateinit var adapter: UsersAdapter
    lateinit var userList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)
        configObserver()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false)
        configList()
        binding.loadingContent.loading.visibility = View.VISIBLE
        viewModel.getUsers()
        return binding.root
    }

    private fun configObserver() {
        val observer = Observer<Users> { result ->
            userList.clear()
            userList.addAll(result.results)
            adapter.notifyDataSetChanged()
            binding.loadingContent.loading.visibility = View.GONE
        }
        viewModel.usersLiveData.observe(this, observer)
    }

    private fun configList() {
        userList = ArrayList()
        adapter = UsersAdapter(userList, { user ->
            val bundle = bundleOf(Constants.BUNDLE_USER to user)
            Navigation.findNavController(binding.root).navigate(R.id.action_list_to_detail, bundle)
        })
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recycler.layoutManager = layoutManager
        binding.recycler.adapter = adapter
    }

}