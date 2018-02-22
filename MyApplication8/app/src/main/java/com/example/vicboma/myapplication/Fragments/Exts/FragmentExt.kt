package com.example.vicboma.myapplication.Fragments.Exts

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat
import android.widget.FrameLayout
import com.example.vicboma.myapplication.MainActivity
import com.example.vicboma.myapplication.R

//Ext function
fun FragmentManager.changeFragment(func :  FragmentTransaction.() -> Unit ) {
    val transaction = this.beginTransaction()
    transaction.func()
    transaction.commit()
}

fun Fragment.stateMachine() = (getActivity() as MainActivity).stateMachine;

