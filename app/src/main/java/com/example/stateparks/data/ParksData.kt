package com.example.stateparks.data

import android.content.Context
import com.example.stateparks.R

class ParksData(val context: Context) {
    fun getParksList(): Array<String> {
        return context.resources.getStringArray(R.array.parks_array)
    }
}