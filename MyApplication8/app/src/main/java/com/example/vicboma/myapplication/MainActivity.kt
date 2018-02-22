package com.example.vicboma.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.vicboma.myapplication.animation.TransitionColor
import com.example.vicboma.myapplication.lifeCycle.LIFE_CYCLE
import com.example.vicboma.myapplication.stateMachine.StateMachine

class MainActivity : AppCompatActivity() {

    val transitionColor = TransitionColor(StateMachine(this));

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transitionColor.fadeIn(R.color.holo_blue_dark, R.id.frameLayoutLobby, LIFE_CYCLE.LOBBY)

    }
}
