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
import com.example.stateparks.databinding.FragmentParksBinding

class ParksFragment : Fragment() {

//    private lateinit var parksViewModel: ParksViewModel

    private val parksList = listOf<String>(
        "Anasazi", "Antelope Island",
        "Bear Lake", "Camp Floyd", "Coral Pink",
        "Dead Horse",
        "Deer Creek",
        "East Canyon",
        "Echo",
        "Edge of The Cedars",
        "Escalante Petrified Forest",
        "Flight Park",
        "Fred Hayes at Starvation",
        "Fremont Indian",
        "Forntier Homestead",
        "Goblin Valley",
        "Goosenecks",
        "Great Salt Lake",
        "Green River",
        "Gunlock",
        "Heritage Park",
        "Historic Union Pacific Rail Trail",
        "Huntington",
        "Hyrum",
        "Jordan River",
        "Jordanelle",
        "Kodachrome Basin",
        "Millsite",
        "Otter Creek",
        "Palisade",
        "Piute",
        "Quail Creek",
        "Red Fleet",
        "Rockport",
        "Sand Hollow",
        "Scofield",
        "Snow Canyon",
        "Steinaker",
        "Territorial Statehouse",
        "Utah Field House",
        "Utah Lake",
        "Wasatch Mountain",
        "Willard Bay",
        "Yuba"
    )
    private val imageList = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentParksBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_parks, container, false
        )

        val recyclerView: RecyclerView = binding.parksRecyclerView
        recyclerView.adapter = ParksRecyclerAdapter(parksList, imageList)

        return binding.root
    }

//    private fun addToList(title: String, image: Int) {
//        parksList.add(title)
//        imageList.add(image)
//    }
//
//    private fun postToList() {
//        for (i in 0 until parksList.size) {
//            addToList(parksList[i], R.mipmap.ic_launcher_round)
//        }
//    }

}