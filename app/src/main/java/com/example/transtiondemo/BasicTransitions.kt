package com.example.transtiondemo

import android.os.Bundle
import android.os.Handler
import android.transition.AutoTransition
import androidx.appcompat.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager

import android.transition.Scene
import kotlinx.android.synthetic.main.activity_basic_transitions.*

import android.transition.Transition
import android.view.ViewGroup
import android.transition.Fade
import android.transition.TransitionSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout


class BasicTransitions : AppCompatActivity(){


    private val tag = "BasicTransitions"
    var tagIndex = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_transitions)

        begin.setOnClickListener {
            if(tagIndex%2 == 0){
                defaultTransitionA()
            }else{
                defaultTransitionB()
            }
            tagIndex++;
        }

        addtarget.setOnClickListener {
            addTarget()
        }

    }

    private fun defaultTransitionA() {
        val scene2 = Scene.getSceneForLayout(rootView, R.layout.scene2, this@BasicTransitions)
        TransitionManager.go(scene2, ChangeColor())
    }

    private fun defaultTransitionB() {
        val scene2 = Scene.getSceneForLayout(rootView, R.layout.scene3, this@BasicTransitions)
        TransitionManager.go(scene2, ChangeColor())
    }

    private fun addTarget() {
        val scene2 = Scene.getSceneForLayout(rootView, R.layout.scene2, this@BasicTransitions)
        val changeBounds = ChangeBounds()
        changeBounds.addTarget(R.id.image1)
        TransitionManager.go(scene2, changeBounds)
    }


}