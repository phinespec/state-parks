package com.example.stateparks.adapters

import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stateparks.R
import com.example.stateparks.data.Activity
import kotlinx.android.synthetic.main.activity_item.view.*

class ActivitiesRecyclerAdapter(val context: Context, val activitiesList: List<Activity>):
    RecyclerView.Adapter<ActivitiesRecyclerAdapter.ActivitiesViewHolder>() {

    inner class ActivitiesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val activityTitle: TextView = itemView.itemText
        val activityImage: ImageView = itemView.itemImage

        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                val activity = activitiesList[position]
                Log.i("info", "Activity ${position}")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item, parent, false)

        return ActivitiesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val activity = activitiesList.get(position)

        val imageList = listOf(
            R.drawable.offroading, R.drawable.boating, R.drawable.camping,
            R.drawable.golf, R.drawable.fishing, R.drawable.hiking,
            R.drawable.mountain_biking, R.drawable.museums, R.drawable.dark_sky, R.drawable.jr_ranger
        )

        holder.activityTitle.text = activity?.title
        holder.activityImage.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int {
        return activitiesList.size
    }
}