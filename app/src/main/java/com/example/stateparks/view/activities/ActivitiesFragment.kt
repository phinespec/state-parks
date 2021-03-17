package com.example.stateparks.view.activities

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
import com.example.stateparks.data.ParksDatabase
import com.example.stateparks.view.parks.ParksViewModel
import com.example.stateparks.view.parks.ParksViewModelFactory

class ActivitiesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding: com.example.stateparks.databinding.FragmentActivitiesBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_activities, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = ParksDatabase.getInstance(application).activitiesDatabaseDao
        val viewModelFactory = ActivitiesViewModelFactory(dataSource, application)
        val activitiesViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(ActivitiesViewModel::class.java)

        val activities = activitiesViewModel.database.getAllActivities()


        binding.viewModel = activitiesViewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}