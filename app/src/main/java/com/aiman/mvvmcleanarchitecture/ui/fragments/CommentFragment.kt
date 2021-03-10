package com.aiman.mvvmcleanarchitecture.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.aiman.mvvmcleanarchitecture.R
import com.aiman.mvvmcleanarchitecture.databinding.FragmentCommentBinding


class CommentFragment : Fragment() {

    private lateinit var binding: FragmentCommentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_comment, container, false)
        return binding.root
    }

}