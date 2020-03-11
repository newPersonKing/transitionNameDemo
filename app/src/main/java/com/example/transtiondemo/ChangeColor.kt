package com.example.transtiondemo

import android.graphics.drawable.ColorDrawable
import android.transition.Transition
import android.transition.TransitionValues
import android.animation.ValueAnimator
import android.view.ViewGroup
import android.animation.Animator
import android.animation.ArgbEvaluator


class ChangeColor : Transition(){


    private val PROPNAME_BACKGROUND =
        "changecolor_background"

    override fun captureStartValues(transitionValues: TransitionValues) {
        if (transitionValues.view.getBackground() is ColorDrawable) {
            captureValues(transitionValues);
        }
    }

    override fun captureEndValues(transitionValues: TransitionValues) {
        if (transitionValues.view.getBackground() is ColorDrawable) {
            captureValues(transitionValues);
        }
    }

    private fun captureValues(transitionValues: TransitionValues) {
        val view = transitionValues.view
        transitionValues.values[PROPNAME_BACKGROUND] =
            (transitionValues.view.background as ColorDrawable).color
    }

    //新建动画
    override fun createAnimator(
        sceneRoot: ViewGroup,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator? {
        if (null == startValues || null == endValues) {
            return null
        }
        val view = endValues.view
        val startBackground = startValues.values[PROPNAME_BACKGROUND] as Int
        val endBackground = endValues.values[PROPNAME_BACKGROUND] as Int

        if (startBackground != endBackground) {
            val animator = ValueAnimator.ofObject(
                ArgbEvaluator(),
                startBackground, endBackground
            )
            animator.duration = 8000
            animator.addUpdateListener { animation ->
                val value = animation.animatedValue
                if (null != value) {
                    view.setBackgroundColor(value as Int)
                }
            }
            return animator
        }
        return null
    }

    //返回我们定义的一些存储Key，注意，这里一定要复写
    override fun getTransitionProperties(): Array<String> {
        return arrayOf(PROPNAME_BACKGROUND)
    }
}