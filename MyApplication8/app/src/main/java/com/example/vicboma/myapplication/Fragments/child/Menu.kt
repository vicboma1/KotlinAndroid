package com.example.vicboma.myapplication.fragments.child


import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vicboma.myapplication.lifeCycle.LIFE_CYCLE
import com.example.vicboma.myapplication.R
import com.example.vicboma.myapplication.fragments.exts.transitionColor

import kotlinx.android.synthetic.main.fragment_menu.*


class Menu : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        transitionColor().fadeIn(R.color.holo_green_dark, R.id.frameLayoutMenu)

        btnMenu.setOnClickListener {
            transitionColor().fadeOut(R.color.holo_green_dark, R.id.frameLayoutMenu,LIFE_CYCLE.READY)
        }

    }
}
