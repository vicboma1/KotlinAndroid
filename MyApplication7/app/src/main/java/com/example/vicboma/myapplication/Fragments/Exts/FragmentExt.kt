package com.example.vicboma.myapplication.Fragments.Exts

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

//Ext function
fun FragmentManager.changeFragment(func :  FragmentTransaction.() -> Unit ) {
    val transaction = this.beginTransaction()
    transaction.func()
    transaction.commit()
}



