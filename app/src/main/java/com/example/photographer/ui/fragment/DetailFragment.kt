package com.example.photographer.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.photographer.R
import com.example.photographer.business.model.User
import com.example.photographer.databinding.DetailFragmentBinding
import com.example.photographer.ui.utility.helper.Constants
import com.squareup.picasso.Picasso

class DetailFragment: Fragment() {

    lateinit var binding: DetailFragmentBinding
    lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false)
        user = arguments?.getSerializable(Constants.BUNDLE_USER) as User
        configUI()
        return binding.root
    }

    fun configUI() {
        user.image?.let {
            Picasso.get()
                .load(it)
                .into(binding.image)
        }

        binding.name.text = user.firstName
        user.facebook?.let { binding.facebook.text = it }
        user.instagram?.let { binding.instagram.text = it }
        user.webpage?.let { binding.webpage.text = it }
    }


}