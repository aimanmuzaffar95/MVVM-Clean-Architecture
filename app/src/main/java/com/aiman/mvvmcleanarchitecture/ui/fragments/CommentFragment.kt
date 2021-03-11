package com.aiman.mvvmcleanarchitecture.ui.fragments

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
import com.aiman.mvvmcleanarchitecture.databinding.FragmentCommentBinding
import com.aiman.mvvmcleanarchitecture.di.ViewModelFactory
import com.aiman.mvvmcleanarchitecture.models.CommentsModel
import com.aiman.mvvmcleanarchitecture.utils.Utils
import com.aiman.mvvmcleanarchitecture.viewmodels.CommentsFragmentViewModel
import javax.inject.Inject


class CommentFragment : Fragment() {

    private lateinit var binding: FragmentCommentBinding
    private lateinit var viewModel: CommentsFragmentViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_comment, container, false)

        MyApplication.getAppComponent(requireContext()).inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(CommentsFragmentViewModel::class.java)

        viewModel.getCommentsResponseLiveData().observe(this,
            Observer {
                consumeResponse(it)
            }
        )

        return binding.root
    }

    private fun consumeResponse(apiResponse: ApiResponse<ArrayList<CommentsModel>>?) {
        when (apiResponse?.status) {

            Status.LOADING -> {
                binding.progressBar.visibility = Utils.visible
                binding.commentsRecycler.visibility = Utils.gone
            }
            Status.SUCCESS -> {
                binding.commentsList = apiResponse.data as ArrayList<CommentsModel>
                binding.progressBar.visibility = Utils.gone
                binding.commentsRecycler.visibility = Utils.visible
            }
            Status.ERROR -> {
                binding.progressBar.visibility = Utils.gone
                binding.commentsRecycler.visibility = Utils.gone
                Utils.showAlertMessage(requireContext(), apiResponse.error?.message.toString())
            }
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.hitGetComments()
    }

}