package com.example.stateparks.view.parks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.stateparks.R
import com.example.stateparks.databinding.FragmentParksBinding

class ParksFragment : Fragment() {

//    private lateinit var parksViewModel: ParksViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding: FragmentParksBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_parks, container, false)

        return binding.root
    }

}