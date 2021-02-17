package com.example.stateparks.view.reserve

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.stateparks.R
import com.example.stateparks.databinding.FragmentParksBinding
import com.example.stateparks.databinding.FragmentReserveBinding

class ReserveFragment : Fragment() {
    //    private lateinit var parksViewModel: ParksViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding: FragmentReserveBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_reserve, container, false)

        return binding.root
    }
}