package com.example.vicboma.myapplication.Fragments.child

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vicboma.myapplication.Fragments.Exts.changeFragment
import com.example.vicboma.myapplication.LifeCycle.LIFE_CYCLE
import com.example.vicboma.myapplication.MainActivity
import com.example.vicboma.myapplication.R

import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_lobby.*

class Lobby : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lobby, container, false)
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnLobby.setOnClickListener {
            (getActivity() as MainActivity)
                    .stateMachine
                    .change(LIFE_CYCLE.MENU)
        }

    }
}
