package com.example.stateparks.data

import androidx.annotation.DrawableRes

data class Park (
    val id: Long,
    val name: String,
    @DrawableRes
    val image: Int?,
    val description: String
    )