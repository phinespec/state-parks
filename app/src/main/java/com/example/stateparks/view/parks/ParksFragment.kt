package com.example.stateparks.view.parks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.stateparks.R
import com.example.stateparks.adapters.ParksRecyclerAdapter
import com.example.stateparks.data.Park
import com.example.stateparks.data.ParksDatabase
import com.example.stateparks.databinding.FragmentParksBinding
import com.example.stateparks.workers.SeedDatabaseWorker
import com.google.gson.Gson

class ParksFragment : Fragment() {

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

        val parks = parksViewModel.database.getAllParks()

        val recyclerView: RecyclerView = binding.parksRecyclerView

        parks.observe(viewLifecycleOwner, Observer { parksList ->
            recyclerView.adapter = ParksRecyclerAdapter(requireContext(), parksList)
        })


        binding.parksViewModel = parksViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

}