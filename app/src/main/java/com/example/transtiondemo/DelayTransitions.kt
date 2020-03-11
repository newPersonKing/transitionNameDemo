package com.example.transtiondemo

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.view.ViewGroup
import android.transition.TransitionManager
import android.transition.ChangeBounds
import kotlinx.android.synthetic.main.activity_delay_transition.*




class DelayTransitions : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_delay_transition)

//        goDelayTransition()

       var  handler = Handler()
        handler.postDelayed(Runnable { goDelayTransition() }, 3000)
    }

    private fun goDelayTransition() {
        val changeBounds = ChangeBounds()
        /*设置动画执行的时间*/
        changeBounds.duration = 10000
        /*这里设置之后 之后修改view的属性 改变的时候是带有动画效果的 如果不设置 就是直接改变 中间没有动画效果*/
        TransitionManager.beginDelayedTransition(rootView, changeBounds)
        val layoutParams = circulView1.getLayoutParams()
        layoutParams.height = 400
        layoutParams.width = 400
        circulView1.setLayoutParams(layoutParams)

        val layoutParams2 = circulView2.getLayoutParams()
        layoutParams2.height = 100
        layoutParams2.width = 100
        circulView2.setLayoutParams(layoutParams2)
    }

}