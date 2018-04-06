package com.capgemini.poc.modelo.acceso.transitionactivities

import android.os.Bundle
import android.app.Activity
import android.transition.*
import android.transition.TransitionManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val res = this.intent.extras.getString(MainActivity.PUT_STRING, "Empty")
        this.textView.text = res
    }

}
