package com.example.stateparks.data

import android.content.res.Resources
import com.example.stateparks.R

fun parksList(resources: Resources): List<Park> {
    return listOf(
        Park(
            id = 1,
            name = "Anasazi",
            image = R.drawable.arches,
            description = "A lovely spot to hang out and watch the stars."
        ),

        Park(
            id = 2,
            name = "Antelope Island",
            image = R.drawable.canyonlands,
            description = "Where the deer and the antelope play."
        ),

        Park(
            id = 3,
            name = "Bear Lake",
            image = R.drawable.gunlock,
            description = "Only a few people have drowned in this beautiful lake"
        )
    )
}