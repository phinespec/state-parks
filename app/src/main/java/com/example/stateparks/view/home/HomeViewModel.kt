package com.example.stateparks.view.home

import android.animation.ObjectAnimator
import android.view.View

class HomeViewModel {

    fun fadeInText(view: View) {
        val animator = ObjectAnimator.ofFloat(view, View.ALPHA, 0f).apply {
            start()
        }
    }
}