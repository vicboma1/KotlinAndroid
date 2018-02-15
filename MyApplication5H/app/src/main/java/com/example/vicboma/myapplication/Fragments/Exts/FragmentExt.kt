package com.example.vicboma.myapplication.Fragments.Exts

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.example.vicboma.myapplication.Fragments.child.BlankFragment
import com.example.vicboma.myapplication.Fragments.child.OrangeFragment
import com.example.vicboma.myapplication.R

val first = BlankFragment()
val second = OrangeFragment()

//Ext function
fun FragmentManager.changeFragment(func :  FragmentTransaction.() -> Unit ) {
    val transaction = this.beginTransaction()
    transaction.func()
    transaction.commit()
}