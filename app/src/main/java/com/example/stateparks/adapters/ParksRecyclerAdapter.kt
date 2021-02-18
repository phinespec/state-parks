package com.example.stateparks.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stateparks.R

class ParksRecyclerAdapter(val parksList: Array<String>) :
        RecyclerView.Adapter<ParksRecyclerAdapter.ParksViewHolder>() {

    class ParksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val parksTextView: TextView = itemView.findViewById(R.id.parks_text)

        fun bind(parkName: String) {
            parksTextView.text = parkName
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
        holder.bind(parksList[position])
    }
}