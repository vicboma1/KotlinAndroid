package com.example.vicboma.myapplication.LifeCycle

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import com.example.vicboma.myapplication.Fragments.Exts.changeFragment
import com.example.vicboma.myapplication.Fragments.child.*
import com.example.vicboma.myapplication.R

enum class LIFE_CYCLE {
    LOBBY,
    MENU,
    READY,
    GAME,
    NEXT_LEVEL,
    GAME_OVER,
    NONE
}

