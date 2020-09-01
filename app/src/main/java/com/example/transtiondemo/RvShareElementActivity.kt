package com.example.transtiondemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_share_element_transition.*

class RvShareElementActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val transName = intent.getStringExtra("transName")
        setContentView(R.layout.activity_share_element_transition)
        iv_share.transitionName = transName?:""

    }

}