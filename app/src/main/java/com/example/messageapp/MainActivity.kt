package com.example.messageapp

import Engine.RabbitMq.ConnectionRabbitMq
import Engine.RabbitMq.RabbitMq
import Engine.Services.ServiceForRabbitMq
import View.ViewChat.ViewChoiseUser.FragmentChoiseUser
import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import kotlinx.coroutines.Delay
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.selects.select

val SUCCESFULL_REGISTER_SAVE = "succesfulregister"
class MainActivity : AppCompatActivity() {

    var fragmentz = 0
    val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("hello", Context.MODE_PRIVATE)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        ConnectionRabbitMq


        startService(Intent(this, ConnectionRabbitMq::class.java))


        switchFragment(FragmentChoiseUser())

        sharedSave(false)

        fragmentz = sharedPreferences.getInt(SUCCESFULL_REGISTER_SAVE, 0)

        Log.d("fragg", fragmentz.toString())

        if (fragmentz == 1) {

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.emptyFragment, Navigation_menu())
                commit()
            }
        }
    }

    fun switchFragment(ft: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.emptyFragment, ft)
            addToBackStack(null)
            commit()
        }
    }


    fun sharedSave(boolean: Boolean) {

        if (boolean == true) {
            fragmentz = 1
            Log.d("qwe", fragmentz.toString())
            if (fragmentz == 1) {
                var editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putInt(SUCCESFULL_REGISTER_SAVE, fragmentz)
                editor.apply()
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.emptyFragment, Navigation_menu())
                    commit()
                }
            }

        }
    }

}









