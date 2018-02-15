package com.example.vicboma.myapplication.Fragments.controller

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.vicboma.myapplication.Fragments.child.BlankFragment
import com.example.vicboma.myapplication.Fragments.child.OrangeFragment
import com.example.vicboma.myapplication.R

class FragmenManagerApp constructor(appCompatActivity: AppCompatActivity) {

    //constructor scope
    private val managerFragment = appCompatActivity.supportFragmentManager
    private var isFragmentLoad = false
    private val fragmentOne = BlankFragment()
    private val fragmentTwo = OrangeFragment()

    //static declarations
    companion object {

    }

    //functions
    fun changeFragment() {
        var actualFragment: Fragment = fragmentOne
        if(isFragmentLoad)
            actualFragment = fragmentTwo

        showFragment(R.id.fragment_holder,actualFragment)

        isFragmentLoad = !isFragmentLoad
    }

    private fun showFragment(source : Int, target : Fragment) {
        val transaction = managerFragment.beginTransaction()
        transaction.replace(source, target)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}