package com.example.stateparks.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.stateparks.MainNavigationDirections
import com.example.stateparks.R
import com.example.stateparks.data.Park
import com.example.stateparks.data.ParksDatabase
import com.example.stateparks.data.ParksDatabaseDao
import com.example.stateparks.view.parks.ParksFragmentDirections
import com.example.stateparks.view.parks.ParksViewModel
import kotlinx.android.synthetic.main.parks_item.view.*

class ParksRecyclerAdapter(val context: Context, val parksList: List<Park>) :
        RecyclerView.Adapter<ParksRecyclerAdapter.ParksViewHolder>() {


    inner class ParksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvParkTitle: TextView = itemView.park_title
        val tvParkDescription: TextView = itemView.park_description

        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                val park = parksList[position]

                v.findNavController().navigate(MainNavigationDirections.actionGlobalMapFragment(park))

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParksViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.parks_item, parent, false)

        return ParksViewHolder(view)
    }

    override fun getItemCount(): Int {
        return parksList.size
    }

    override fun onBindViewHolder(holder: ParksViewHolder, position: Int) {

        val park = parksList[position]

        holder.tvParkTitle.text = park.parkName
        holder.tvParkDescription.text = park.remarks
    }
}

class ParkListener(val clickListener: (parkId: Long) -> Unit) {
    fun onClick(park: Park) = clickListener(park.parkId)
}