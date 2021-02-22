package com.example.stateparks.view.parks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.stateparks.R
import com.example.stateparks.adapters.ParksRecyclerAdapter
import com.example.stateparks.data.ParksData
import com.example.stateparks.databinding.FragmentParksBinding

class ParksFragment : Fragment() {

//    private lateinit var parksViewModel: ParksViewModel

    private val parksList = mutableListOf<String>()
    private val imageList = mutableListOf<Int>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding: FragmentParksBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_parks, container, false)

        val recyclerView: RecyclerView = binding.parksRecyclerView
        recyclerView.adapter = ParksRecyclerAdapter(parksList, imageList)

        postToList()

        return binding.root
    }

    private fun addToList(title: String, image: Int) {
        parksList.add(title)
        imageList.add(image)
    }

    private fun postToList() {
        for (i in 1..25) {
            addToList("Title $i", R.mipmap.ic_launcher_round)
        }
    }

}