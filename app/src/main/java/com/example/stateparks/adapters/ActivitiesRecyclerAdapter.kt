package com.example.stateparks.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stateparks.R
import com.example.stateparks.data.Activity

class ActivitiesRecyclerAdapter(val context: Context, val activitiesList: List<Activity>):
    RecyclerView.Adapter<ActivitiesRecyclerAdapter.ActivitiesViewHolder>() {

    inner class ActivitiesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val 
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item, parent, false)

        return ActivitiesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val activity = activitiesList.get(position)
    }

    override fun getItemCount(): Int {
        return activitiesList.size
    }
}