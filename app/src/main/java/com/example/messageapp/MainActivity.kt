package com.example.messageapp

import Engine.Enums.example
import Engine.Notyfi.Notify
import Engine.Notyfi.notifySingle
import Engine.RabbitMq.ConnectionRabbitMq
import Engine.RabbitMq.ConnectionRabbitMqService
import View.ViewChat.Register.ViewChoiseUser.FragmentChoiseUser
import android.annotation.SuppressLint
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.coroutines.runBlocking

val SUCCESFULL_REGISTER_SAVE = "succesfulregister"
class MainActivity : AppCompatActivity() {


    var fragmentz = 0
    val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("hello", Context.MODE_PRIVATE)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notifySingle.SetMainActivityContext(this,this)
//        var i = Intent(this, example().javaClass)
//        ConnectionRabbitMqService().SetNotify(notifySingle.GetNotify())
//        startService(Intent(this, ConnectionRabbitMqService()::class.java))

//        ConnectionRabbitMq().onCreates()

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

    override fun onStop()  {
        super.onStop()
//        ConnectionRabbitMq().StopRabbitMq()
//        notifySingle.SetMainActivityContext(this,this)
        ConnectionRabbitMqService().SetNotify(notifySingle.GetNotify())
        startService(Intent(this, ConnectionRabbitMqService()::class.java))
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









