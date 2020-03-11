package com.example.transtiondemo

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.transition.TransitionManager
import androidx.core.os.HandlerCompat.postDelayed
import kotlinx.android.synthetic.main.activity_custom_transition.*


class CustomTransition : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_transition)

        Handler().postDelayed(Runnable {
            TransitionManager.beginDelayedTransition(rootView, ChangeColor())
            animatorView.setBackgroundColor(-0xcb9a99)
        }, 2000)
    }

}