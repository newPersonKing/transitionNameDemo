package com.example.transtiondemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.transition.Slide
import android.transition.Fade
import android.view.View
import android.view.Window
import android.view.Window.FEATURE_ACTIVITY_TRANSITIONS
import kotlinx.android.synthetic.main.activity_main.*
import android.app.ActivityOptions
import android.transition.Explode
import android.util.Pair
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTransiton()
        setContentView(R.layout.activity_main)

        basic_transition.setOnClickListener {

            startActivity(Intent(this,BasicTransitions::class.java))

        }

        delay_transition.setOnClickListener {
            startActivity(Intent(this,DelayTransitions::class.java))

        }

        custom_transition.setOnClickListener {
            startActivity(Intent(this,CustomTransition::class.java))
        }

        view_overlay.setOnClickListener {
            startActivity(Intent(this,ViewOverlayActivity::class.java))
        }

        content_Transition.setOnClickListener {
            ViewCompat.setTransitionName(content_Transition,"postButton");
            var intent = Intent(this,ContentTransition::class.java)
            intent.putExtra("postButton","postButton")
            var pair = Pair.create(content_Transition as View,"postButton")
            startActivity(
                intent,
                /*这个参数会使setTransiton中的动画有效果*/
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }

        share_Transition.setOnClickListener{
            startActivity(
                Intent(this@MainActivity, ShareElementTransition::class.java),
                ActivityOptions.makeSceneTransitionAnimation(this, share_Transition, "share").toBundle()
            )
            share_Transition.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent))
        }
    }

    fun setTransiton(){
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        window.allowEnterTransitionOverlap = true
        window.allowReturnTransitionOverlap = true
        val fade = Fade()
        /*页面中的元素从两边散开*/
        val ex = Explode()
        ex.duration = 300
        fade.duration = 300
        window.exitTransition = ex


        /*定义页面返回的时候从底部返回*/
        val slide = Slide(Gravity.BOTTOM)
        slide.duration = 300
        window.reenterTransition = slide
        val changeColor = ChangeColor()
        changeColor.setDuration(3000)
        window.sharedElementExitTransition = changeColor
    }

}
