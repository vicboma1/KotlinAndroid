package com.capgemini.poc.modelo.acceso.transitionactivities

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent



class MainActivity : Activity() {

    companion object {
        var PUT_STRING : String = "entry"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.button.setOnClickListener {

            val intent = Intent(this@MainActivity, Main2Activity::class.java)
            intent.putExtra(PUT_STRING, "${Name.text} ${Surname.text}")
            startActivity(intent)
        }
    }
}
