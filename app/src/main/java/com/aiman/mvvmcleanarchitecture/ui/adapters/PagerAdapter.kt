package com.aiman.mvvmcleanarchitecture.ui.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.aiman.mvvmcleanarchitecture.R
import com.aiman.mvvmcleanarchitecture.ui.fragments.CommentFragment
import com.aiman.mvvmcleanarchitecture.ui.fragments.PostFragment
import com.aiman.mvvmcleanarchitecture.ui.fragments.UserFragment
import java.lang.Exception

const val FRAGMENT_COUNT = 3

class PagerAdapter(fragmentManager: FragmentManager, private val context: Context):
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> UserFragment()
            1 -> PostFragment()
            2 -> CommentFragment()
            else -> throw Exception("Unexpected value of position inside getItem() of PagerAdapter")
        }
    }

    override fun getCount(): Int {
        return  FRAGMENT_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> context.getString(R.string.tab_title_users)
            1 -> context.getString(R.string.tab_title_posts)
            2 -> context.getString(R.string.tab_title_comments)
            else -> throw Exception("Unexpected value of position inside getPageTitle() of PagerAdapter")
        }
    }
}