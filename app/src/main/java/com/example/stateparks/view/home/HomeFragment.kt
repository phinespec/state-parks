package com.example.stateparks.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.stateparks.R
import com.example.stateparks.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    //    private lateinit var parksViewModel: ParksViewModel

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false)

        return binding.root
    }
}