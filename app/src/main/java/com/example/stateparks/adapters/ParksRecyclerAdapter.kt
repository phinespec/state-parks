package com.example.stateparks.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.stateparks.R
import com.example.stateparks.data.Park
import kotlinx.android.synthetic.main.parks_item.view.*

class ParksRecyclerAdapter(val context: Context, val parksList: List<Park>) :
        RecyclerView.Adapter<ParksRecyclerAdapter.ParksViewHolder>() {

    inner class ParksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvParkTitle: TextView = itemView.park_title
        val tvParkDescription: TextView = itemView.park_description


        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "You clicked item # ${position + 1}",
                Toast.LENGTH_SHORT).show()
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

        val park = parksList.get(position)

        holder.tvParkTitle.text = park?.parkName
        holder.tvParkDescription.text = park?.remarks
    }
}