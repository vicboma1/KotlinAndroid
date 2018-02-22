package com.example.vicboma.myapplication.Fragments.child


import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vicboma.myapplication.Fragments.Exts.stateMachine
import com.example.vicboma.myapplication.LifeCycle.LIFE_CYCLE
import com.example.vicboma.myapplication.MainActivity

import com.example.vicboma.myapplication.R
import kotlinx.android.synthetic.main.fragment_next_level.*


class NextLevel : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_next_level, container, false)
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        stateMachine().transitionColorFadeIn(R.color.holo_purple_dark, R.id.frameLayoutNextLevel)

        btnNextLevel.setOnClickListener {
            stateMachine().transitionColorFadeOut(R.color.holo_purple_dark, R.id.frameLayoutNextLevel, LIFE_CYCLE.GAME_OVER)
        }
    }

}
