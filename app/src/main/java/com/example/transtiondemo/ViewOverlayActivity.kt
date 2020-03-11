package com.example.transtiondemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_view_overlay.*


class ViewOverlayActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_view_overlay)

        var textView = TextView(this)
        textView.setText("这是测试view=======================aslajsdlakdjalksdjalsdjaldskl")
        click_me.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val container = click_me.getParent().getParent() as ViewGroup
                container.overlay.add(textView)
                textView.layout(100,200,200,400)
                val anim = ObjectAnimator.ofFloat(textView, "translationY", container.height.toFloat())
                val rotate = ObjectAnimator.ofFloat(textView, "rotation", 0F, 360F)
                rotate.setRepeatCount(ValueAnimator.INFINITE)
                rotate.setRepeatMode(ValueAnimator.REVERSE)
                rotate.setDuration(3500)
                anim.setDuration(3000)

                anim.addListener(object : Animator.AnimatorListener {

                    override fun onAnimationStart(arg0: Animator) {}

                    override fun onAnimationRepeat(arg0: Animator) {}

                    override fun onAnimationEnd(arg0: Animator) {
                        container.overlay.remove(textView)
                    }

                    override fun onAnimationCancel(arg0: Animator) {
                        container.overlay.remove(textView)
                    }
                })
                val animatorSet = AnimatorSet()
                animatorSet.playTogether(anim, rotate)
                animatorSet.start()
            }
        })

    }

}