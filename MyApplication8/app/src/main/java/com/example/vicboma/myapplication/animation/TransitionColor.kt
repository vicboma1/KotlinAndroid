package com.example.vicboma.myapplication.animation

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import com.example.vicboma.myapplication.fragments.exts.changeFragment
import com.example.vicboma.myapplication.fragments.child.*
import com.example.vicboma.myapplication.lifeCycle.LIFE_CYCLE
import com.example.vicboma.myapplication.R
import android.animation.Animator
import android.animation.Animator.AnimatorListener
import com.example.vicboma.myapplication.stateMachine.StateMachine
import kotlinx.coroutines.experimental.*


class TransitionColor constructor(val stateMachine :  StateMachine){

    private var delay = 300L

    companion object {

    }

    fun fadeOut(colorInit : Int, fragmentId: Int, state : LIFE_CYCLE = LIFE_CYCLE.NONE) :  TransitionColor  =
            animationColorFadeOut(colorInit, fragmentId, state)

    fun fadeIn(colorInit : Int, fragmentId: Int, state : LIFE_CYCLE = LIFE_CYCLE.NONE) :  TransitionColor  =
            animationColorFadeIn(colorInit, fragmentId, state)

    private fun animationColorFadeOut(colorInit : Int, fragmentId: Int, state : LIFE_CYCLE) :  TransitionColor  =
            animationColorFadeOut(colorInit, fragmentId, delay,state)

    private fun animationColorFadeIn(colorInit : Int, fragmentId: Int, state : LIFE_CYCLE) :  TransitionColor  =
            animationColorFadeIn(colorInit, fragmentId, delay,state)

    private fun animationColorFadeOut(colorInit : Int, fragmentId : Int, duration : Long, state : LIFE_CYCLE) :  TransitionColor  =
            animationColorFade(colorInit, R.color.button_material_dark,fragmentId,duration,state)

    private fun animationColorFadeIn(colorEnd : Int,fragmentId : Int,  duration : Long, state : LIFE_CYCLE) :  TransitionColor  =
            animationColorFade(R.color.button_material_dark, colorEnd,fragmentId,duration,state)


    private fun animationColorFade(colorInit : Int, colorEnd : Int, fragmentId : Int, _duration : Long,state : LIFE_CYCLE) :  TransitionColor {
        //  launch(CommonPool) {
        doAnimation(colorInit , colorEnd, fragmentId , _duration ,state )
        //  }
        return this
    }

    fun doAnimation(colorInit : Int, colorEnd : Int, fragmentId : Int, _duration : Long,state : LIFE_CYCLE)  {
        ObjectAnimator.ofObject(
                stateMachine.activity.findViewById<FrameLayout>(fragmentId),
                "backgroundColor",
                ArgbEvaluator(),
                ContextCompat.getColor(stateMachine.activity, colorInit),
                ContextCompat.getColor(stateMachine.activity, colorEnd)
        ).apply {
            duration = _duration
        }.let {

                    it.addListener(object : Animator.AnimatorListener {

                        override fun onAnimationStart(animation: Animator) {
                        }

                        override fun onAnimationRepeat(animation: Animator) {
                        }

                        override fun onAnimationEnd(animation: Animator) {
                            async {
                                stateMachine.changeAsync(state)
                            }
                        }

                        override fun onAnimationCancel(animation: Animator) {
                        }
                    })
                    it
                }.start()
    }

}
