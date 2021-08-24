package com.example.messageapp

import Engine.RabbitMq.ConnectionRabbitMq
import com.example.messageapp.mvvm.choiseUser.ViewChoiseUser
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.messageapp.AndroidInstrument.AndroidInstrument
import com.example.messageapp.AndroidInstrument.SinglInstrument
import com.example.messageapp.mvvm.buttonNavigation.ViewNavigationMenu

val SUCCESFULL_REGISTER_SAVE = "succesfulregister"
class MainActivity : AppCompatActivity() {


    var fragmentz = 0
    val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("hello", Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //
        SinglInstrument.setInstrument(AndroidInstrument(this))
        //
        var flag = false
        ConnectionRabbitMq.mainAct = this


//        switchFragment(FragmentChoiseUser())
        switchFragment(ViewChoiseUser())



        sharedSave(false)

        fragmentz = sharedPreferences.getInt(SUCCESFULL_REGISTER_SAVE, 0)

        Log.d("fragg", fragmentz.toString())

        if (fragmentz == 1) {

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.emptyFragment, ViewNavigationMenu())
                commit()
            }
        }
    }

    fun switchFragment(ft: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.emptyFragment, ft)
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
                    replace(R.id.emptyFragment, ViewNavigationMenu())
                    commit()
                }
            }

        }
    }
}










