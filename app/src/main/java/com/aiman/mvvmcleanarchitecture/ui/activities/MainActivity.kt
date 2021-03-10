package com.aiman.mvvmcleanarchitecture.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aiman.mvvmcleanarchitecture.R
import com.aiman.mvvmcleanarchitecture.databinding.ActivityMainBinding
import com.aiman.mvvmcleanarchitecture.ui.adapters.PagerAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val fragmentAdapter = PagerAdapter(supportFragmentManager, this)
        binding.viewPager.adapter = fragmentAdapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)

    }
}