package com.capgemini.poc.modelo.acceso.myapplication

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.button.setOnClickListener {
            this@MainActivity.label.text = "Hello World!"
        }
    }
}
