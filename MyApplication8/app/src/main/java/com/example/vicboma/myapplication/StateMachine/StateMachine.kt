package com.example.vicboma.myapplication.StateMachine

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.widget.FrameLayout
import com.example.vicboma.myapplication.Fragments.Exts.changeFragment
import com.example.vicboma.myapplication.Fragments.child.*
import com.example.vicboma.myapplication.LifeCycle.LIFE_CYCLE
import com.example.vicboma.myapplication.R
import android.animation.Animator
import android.animation.Animator.AnimatorListener
import kotlinx.coroutines.experimental.*


class StateMachine constructor(val activity : AppCompatActivity){

    private var delay = 300L
    private var fragment : Fragment? = null

    companion object {

    }

    fun transitionColorFadeOut(colorInit : Int, fragmentId: Int, state : LIFE_CYCLE = LIFE_CYCLE.NONE) :  StateMachine  =
            animationColorFadeOut(colorInit, fragmentId, state)

    fun transitionColorFadeIn(colorInit : Int, fragmentId: Int, state : LIFE_CYCLE = LIFE_CYCLE.NONE) :  StateMachine  =
            animationColorFadeIn(colorInit, fragmentId, state)

    private fun animationColorFadeOut(colorInit : Int, fragmentId: Int, state : LIFE_CYCLE) :  StateMachine  =
         animationColorFadeOut(colorInit, fragmentId, 300,state)

    private fun animationColorFadeIn(colorInit : Int, fragmentId: Int, state : LIFE_CYCLE) :  StateMachine  =
            animationColorFadeIn(colorInit, fragmentId, 300,state)

    private fun animationColorFadeOut(colorInit : Int, fragmentId : Int, duration : Long, state : LIFE_CYCLE ) :  StateMachine  =
            animationColorFade(colorInit, R.color.button_material_dark,fragmentId,duration,state)

    private fun animationColorFadeIn(colorEnd : Int,fragmentId : Int,  duration : Long, state : LIFE_CYCLE) :  StateMachine  =
            animationColorFade(R.color.button_material_dark, colorEnd,fragmentId,duration,state)


    private fun animationColorFade(colorInit : Int, colorEnd : Int, fragmentId : Int, _duration : Long,state : LIFE_CYCLE) :  StateMachine {
      //  launch(CommonPool) {
            doAnimation(colorInit , colorEnd, fragmentId , _duration ,state )
      //  }
            return this
    }

     fun doAnimation(colorInit : Int, colorEnd : Int, fragmentId : Int, _duration : Long,state : LIFE_CYCLE)  {
        ObjectAnimator.ofObject(
                activity.findViewById<FrameLayout>(fragmentId),
                "backgroundColor",
                ArgbEvaluator(),
                ContextCompat.getColor(this@StateMachine.activity, colorInit),
                ContextCompat.getColor(this@StateMachine.activity, colorEnd)
        ).apply {
            duration = _duration
        }.let {

                    it.addListener(object : AnimatorListener {

                        override fun onAnimationStart(animation: Animator) {
                        }

                        override fun onAnimationRepeat(animation: Animator) {
                        }

                        override fun onAnimationEnd(animation: Animator) {
                           async {
                               changeAsync(state)
                           }
                        }

                        override fun onAnimationCancel(animation: Animator) {
                        }
                    })
                    it
                }.start()
    }

    private fun changeAsync(state : LIFE_CYCLE)   {
        if(state == LIFE_CYCLE.NONE)
            return

            fragment = when (state) {
                LIFE_CYCLE.LOBBY -> Lobby()
                LIFE_CYCLE.MENU -> Menu()
                LIFE_CYCLE.READY -> Ready()
                LIFE_CYCLE.GAME -> Game()
                LIFE_CYCLE.NEXT_LEVEL -> NextLevel()
                LIFE_CYCLE.GAME_OVER -> GameOver()
                else ->
                    throw  Exception("Error : Not recognize life cycle state!")
            }

            activity.supportFragmentManager.changeFragment {
                this.replace(R.id.fragment_holder, fragment)
            }
    }

}
