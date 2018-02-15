package com.example.vicboma.myapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.vicboma.myapplication.Fragments.Exts.changeFragment
import com.example.vicboma.myapplication.Fragments.Exts.first
import com.example.vicboma.myapplication.Fragments.Exts.second
import com.example.vicboma.myapplication.Fragments.child.BlankFragment
import com.example.vicboma.myapplication.Fragments.child.OrangeFragment
import com.example.vicboma.myapplication.R.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        var isFragmentLoad = false;

        findViewById<Button>(id.button)
                .setOnClickListener {
                    supportFragmentManager.changeFragment {

                        var actualFragment: Fragment = first
                        if (isFragmentLoad)
                            actualFragment = second

                        this.replace(R.id.fragment_holder, actualFragment)

                        isFragmentLoad = !isFragmentLoad
                    }
                }
    }
}
