package com.example.vicboma.myapplication.StateMachine

import android.support.v7.app.AppCompatActivity
import com.example.vicboma.myapplication.Fragments.Exts.changeFragment
import com.example.vicboma.myapplication.Fragments.child.*
import com.example.vicboma.myapplication.LifeCycle.LIFE_CYCLE
import com.example.vicboma.myapplication.R


class StateMachine constructor(val activity : AppCompatActivity){

    companion object {
    }

    fun change(state : LIFE_CYCLE) : Unit {
        var fragment = when(state){
            LIFE_CYCLE.LOBBY -> Lobby()
            LIFE_CYCLE.MENU -> Menu()
            LIFE_CYCLE.READY-> Ready()
            LIFE_CYCLE.GAME-> Game()
            LIFE_CYCLE.NEXT_LEVEL-> NextLevel()
            LIFE_CYCLE.GAME_OVER -> GameOver()
            else ->
                throw  Exception("Error : Not recognize life cycle state!")
        }

        activity!!.supportFragmentManager.changeFragment {
            this.replace(R.id.fragment_holder, fragment)
        }
    }
}