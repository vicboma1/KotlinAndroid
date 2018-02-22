package com.example.vicboma.myapplication.fragments.exts

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.example.vicboma.myapplication.MainActivity

//Ext function
fun FragmentManager.changeFragment(func :  FragmentTransaction.() -> Unit ) {
    val transaction = this.beginTransaction()
    transaction.func()
    transaction.commit()
}

fun Fragment.transitionColor() = (getActivity() as MainActivity).transitionColor;

