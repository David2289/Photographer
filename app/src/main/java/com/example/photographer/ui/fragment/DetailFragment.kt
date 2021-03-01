package com.example.photographer.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
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

    private fun configUI() {
        user.image?.let {
            Picasso.get()
                .load(it)
                .into(binding.image)
        }

        binding.name.text = user.firstName
        binding.desc.text = user.description
        binding.heart.setOnClickListener { binding.heart.isSelected = true }
        binding.icBack.setOnClickListener { Navigation.findNavController(binding.root).navigate(R.id.action_detail_to_list) }
    }


}