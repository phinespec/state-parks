package com.example.stateparks.view.parks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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

//    private lateinit var parksViewModel: ParksViewModel



//    private val parksDummyData = listOf<Park>(Park(1, "Vernon Worthen", "Lovely little park", 583493.3, 0434.0),
//        Park(2, "Vernon Worthen2", "Lovely little park, ", 583493.3, 0434.0), Park(3, "Vernon Worthen3", "Lovely little park", 583493.3, 0434.0))

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

        // here is where we hook up the adapter with our fragment and pass in our parksList
//        recyclerView.adapter = ParksRecyclerAdapter(requireContext(), )

        binding.parksViewModel = parksViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

}