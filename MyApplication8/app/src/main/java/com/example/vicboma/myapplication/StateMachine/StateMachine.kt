package com.example.vicboma.myapplication.stateMachine

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
import kotlinx.coroutines.experimental.*


class StateMachine constructor(val activity : AppCompatActivity){

    private var fragment : Fragment? = null

    companion object {

    }

    fun changeAsync(state : LIFE_CYCLE)   {
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
