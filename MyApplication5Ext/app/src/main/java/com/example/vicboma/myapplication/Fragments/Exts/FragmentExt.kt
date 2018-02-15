package com.example.vicboma.myapplication.Fragments.Exts

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.example.vicboma.myapplication.Fragments.child.BlankFragment
import com.example.vicboma.myapplication.Fragments.child.OrangeFragment
import com.example.vicboma.myapplication.R

private val first = BlankFragment()
private val second = OrangeFragment()

//Ext function
fun FragmentManager.changeFragment(isFragmentLoad : Boolean)  =
        changeFragment(isFragmentLoad, first, second)

fun FragmentManager.changeFragment(isFragmentLoad : Boolean, first : Fragment, second : Fragment) =
        changeFragment(isFragmentLoad, first, second, R.id.fragment_holder)

fun FragmentManager.changeFragment(isFragmentLoad : Boolean, first : Fragment, second : Fragment, parent : Int ) : Boolean {
    var actualFragment: Fragment = first
    if (isFragmentLoad)
        actualFragment = second

    val transaction = this.beginTransaction()
    transaction.replace(parent, actualFragment)
    transaction.addToBackStack(null)
    transaction.commit()

    return !isFragmentLoad
}