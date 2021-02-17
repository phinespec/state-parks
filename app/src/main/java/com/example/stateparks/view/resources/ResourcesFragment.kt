package com.example.stateparks.view.resources

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.stateparks.R
import com.example.stateparks.databinding.FragmentParksBinding
import com.example.stateparks.databinding.FragmentResourcesBinding

class ResourcesFragment : Fragment() {
    //    private lateinit var parksViewModel: ParksViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding: FragmentResourcesBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_resources, container, false)

        return binding.root
    }
}