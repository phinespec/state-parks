package com.example.stateparks.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.stateparks.R

class ParksRecyclerAdapter(val parksList: List<String>, private var images: List<Int>) :
        RecyclerView.Adapter<ParksRecyclerAdapter.ParksViewHolder>() {

    inner class ParksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val parksTextView: TextView = itemView.findViewById(R.id.parks_text)
        val parksImage: ImageView = itemView.findViewById(R.id.iv_image)


        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "You clicked item # ${position + 1}",
                Toast.LENGTH_SHORT).show()
            }
        }

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
        holder.parksTextView.text = parksList[position]
        holder.parksImage.setImageResource(images[position])
    }
}