package com.example.stateparks.view.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.stateparks.R
import com.example.stateparks.adapters.ActivitiesRecyclerAdapter
import com.example.stateparks.adapters.ParksRecyclerAdapter
import com.example.stateparks.data.ParksDatabase

class ActivitiesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: com.example.stateparks.databinding.FragmentActivitiesBinding =
            DataBindingUtil.inflate(
                inflater, R.layout.fragment_activities, container, false
            )

        val application = requireNotNull(this.activity).application
        val dataSource = ParksDatabase.getInstance(application).activitiesDatabaseDao
        val viewModelFactory = ActivitiesViewModelFactory(dataSource, application)
        val activitiesViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(ActivitiesViewModel::class.java)



        val activities = activitiesViewModel.database.getAllActivities()
        val recyclerView = binding.activitiesRecycler

        binding.viewModel = activitiesViewModel
        binding.lifecycleOwner = this

        val gridLayoutManager = GridLayoutManager(context, 3)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.setHasFixedSize(true)

        activities.observe(viewLifecycleOwner, Observer { activitiesList ->
            recyclerView.adapter = ActivitiesRecyclerAdapter(requireContext(), activitiesList)
        })


        return binding.root


    }
}