package com.aiman.mvvmcleanarchitecture.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aiman.mvvmcleanarchitecture.MyApplication
import com.aiman.mvvmcleanarchitecture.R
import com.aiman.mvvmcleanarchitecture.api.ApiResponse
import com.aiman.mvvmcleanarchitecture.api.Status
import com.aiman.mvvmcleanarchitecture.databinding.FragmentPostBinding
import com.aiman.mvvmcleanarchitecture.di.ViewModelFactory
import com.aiman.mvvmcleanarchitecture.models.PostsModel
import com.aiman.mvvmcleanarchitecture.utils.Utils
import com.aiman.mvvmcleanarchitecture.viewmodels.PostFragmentViewModel
import javax.inject.Inject


class PostFragment : Fragment() {

    private lateinit var binding: FragmentPostBinding
    private lateinit var viewModel: PostFragmentViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_post, container, false
        )

        MyApplication.getAppComponent(activity as Context).inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(PostFragmentViewModel::class.java)

        viewModel.getPostsResponseLiveData().observe(this,
            Observer {
                consumeResponse(it)
            })

        return binding.root
    }

    private fun consumeResponse(apiResponse: ApiResponse<ArrayList<PostsModel>>?) {
        when (apiResponse?.status) {

            Status.LOADING -> {
                binding.progressBar.visibility = Utils.visible
                binding.postsRecycler.visibility = Utils.gone
            }
            Status.SUCCESS -> {
                binding.postsList = apiResponse.data as ArrayList<PostsModel>
                binding.progressBar.visibility = Utils.gone
                binding.postsRecycler.visibility = Utils.visible
            }
            Status.ERROR -> {
                binding.progressBar.visibility = Utils.gone
                binding.postsRecycler.visibility = Utils.gone
                Utils.showAlertMessage(requireContext(), apiResponse.error?.message.toString())
            }
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.hitGetPosts()
    }

}