package com.example.messageapp

import View.ViewChat.ViewChoiseUser.FragmentChoiseUser
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

val SUCCESFULL_REGISTER_SAVE = "succesfulregister"

class MainActivity : AppCompatActivity() {

    var fragmentz = 0

    val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("hello", Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        switchFragment(FragmentChoiseUser())
//        viewFragment(EmptyFragment())

        sharedSave(false)

        fragmentz = sharedPreferences.getInt(SUCCESFULL_REGISTER_SAVE, 0)

        Log.d("fragg", fragmentz.toString())

        if (fragmentz == 1) {

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.constraintFragment, Navigation_menu())
                commit()
            }
        }
    }

    fun switchFragment(ft: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.constraintFragment, ft)
            addToBackStack(null)
            commit()
        }
    }

//    fun viewFragment(ft: Fragment) {
//
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragmentInstruction, ft)
//            commit()
//        }
//    }


    fun sharedSave(boolean: Boolean) {

        if (boolean == true) {
            fragmentz = 1
            Log.d("qwe", fragmentz.toString())
            if (fragmentz == 1) {
                var editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putInt(SUCCESFULL_REGISTER_SAVE, fragmentz)
                editor.apply()
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.constraintFragment, Navigation_menu())
                    commit()
                }
            }

        }
    }
}









