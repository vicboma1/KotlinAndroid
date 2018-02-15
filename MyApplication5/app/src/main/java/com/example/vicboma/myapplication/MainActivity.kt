package com.example.vicboma.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.vicboma.myapplication.Fragments.controller.FragmenManagerApp
import com.example.vicboma.myapplication.R.*

class MainActivity : AppCompatActivity() {

    val managerfragment = FragmenManagerApp(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        findViewById<Button>(id.button)
                .setOnClickListener {managerfragment.changeFragment()}
    }


}
