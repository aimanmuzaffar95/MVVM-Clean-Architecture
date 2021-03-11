package com.aiman.mvvmcleanarchitecture.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aiman.mvvmcleanarchitecture.MyApplication
import com.aiman.mvvmcleanarchitecture.R
import com.aiman.mvvmcleanarchitecture.utils.Utils.gone
import com.aiman.mvvmcleanarchitecture.utils.Utils.visible
import com.aiman.mvvmcleanarchitecture.api.ApiResponse
import com.aiman.mvvmcleanarchitecture.api.Status
import com.aiman.mvvmcleanarchitecture.databinding.FragmentUserBinding
import com.aiman.mvvmcleanarchitecture.di.ViewModelFactory
import com.aiman.mvvmcleanarchitecture.models.UsersModel
import com.aiman.mvvmcleanarchitecture.utils.Utils.showAlertMessage
import com.aiman.mvvmcleanarchitecture.viewmodels.UserFragmentViewModel
import javax.inject.Inject


class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding
    private lateinit var viewModel: UserFragmentViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_user, container, false)

        MyApplication.getAppComponent(requireContext()).inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(UserFragmentViewModel::class.java)

        viewModel.getUsersResponseLiveData().observe(this,
            Observer {
            consumeResponse(it)
        })

        return binding.root
    }

    private fun consumeResponse(apiResponse: ApiResponse<ArrayList<UsersModel>>?) {
        when (apiResponse?.status) {

            Status.LOADING -> {
                binding.progressBar.visibility = visible
                binding.usersRecycler.visibility = gone
            }
            Status.SUCCESS -> {
                binding.usersList = apiResponse.data as ArrayList<UsersModel>
                binding.progressBar.visibility = gone
                binding.usersRecycler.visibility = visible
            }
            Status.ERROR -> {
                binding.progressBar.visibility = gone
                binding.usersRecycler.visibility = gone
                showAlertMessage(requireContext(), apiResponse.error?.message.toString())
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.hitGetUsers()
    }

}