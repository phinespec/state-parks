package com.example.stateparks.view.parks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.stateparks.R
import com.example.stateparks.adapters.ParksRecyclerAdapter
import com.example.stateparks.data.ParksDatabase
import com.example.stateparks.data.ParksDatabaseDao
import com.example.stateparks.databinding.FragmentParksBinding
import java.io.InputStream
import java.nio.channels.AsynchronousFileChannel.open

class ParksFragment : Fragment() {

//    private lateinit var parksViewModel: ParksViewModel


    private val imageList = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentParksBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_parks, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = ParksDatabase.getInstance(application).parksDatabaseDao
        val viewModelFactory = ParksViewModelFactory(dataSource, application)
        val parksViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(ParksViewModel::class.java)

        val recyclerView: RecyclerView = binding.parksRecyclerView
//        recyclerView.adapter = ParksRecyclerAdapter()

        binding.parksViewModel = parksViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

}