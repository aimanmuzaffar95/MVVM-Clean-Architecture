package com.aiman.mvvmcleanarchitecture.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.aiman.mvvmcleanarchitecture.R
import com.aiman.mvvmcleanarchitecture.databinding.FragmentPostBinding


class PostFragment : Fragment() {

    private lateinit var binding: FragmentPostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_post, container, false)
        return binding.root
    }

}