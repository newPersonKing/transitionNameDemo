package com.example.transtiondemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_share_element_transition.*

class ShareElementTransition : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_share_element_transition)
        back.transitionName = "share"

    }

}