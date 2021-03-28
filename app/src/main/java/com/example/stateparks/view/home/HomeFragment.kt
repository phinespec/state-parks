package com.example.stateparks.view.home


import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.stateparks.R
import com.example.stateparks.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false)

        fadeInText()



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = binding.viewModel
        viewModel?.fadeInText(binding.subHeading)
    }

    fun fadeInText() {
        val bottomText = binding.subHeading
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        bottomText.startAnimation(animation)
    }
}