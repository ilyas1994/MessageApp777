package com.example.messageapp

import Engine.RabbitMq.ConnectionRabbitMq
import View.ViewChat.Register.ForSupplier.ViewFragmentLoginPassword
import View.ViewChat.Register.ViewChoiseUser.FragmentChoiseUser
import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

val SUCCESFULL_REGISTER_SAVE = "succesfulregister"
class MainActivity : AppCompatActivity() {

    companion object {
        const val NOTIFICATION_ID_INT = 101
        const val CHANNEL_ID_STRING = "Channel 1"
    }

    lateinit var builder: Notification.Builder
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    private    val description = "qwe"


    var fragmentz = 0
    val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("hello", Context.MODE_PRIVATE)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       var flag = false
         ConnectionRabbitMq.mainAct = this

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager



//        switchFragment(FragmentChoiseUser())
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
//
    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel(str: String){
//        if (boolean == true) {
        val intent = Intent(this,  MainActivity
        ::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }


    val pendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(
                CHANNEL_ID_STRING,
                description,
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)
//            var qwe = Intent("Close", "Close2")
            builder = Notification.Builder(this, CHANNEL_ID_STRING)
                .setSmallIcon(R.drawable.viewcustomerdesign)
                .setColor(R.color.colorGreen)

                .setShowWhen(true)
                .setContentTitle("Новое сообщение")
                .setContentText(str)
                .setContentIntent(pendingIntent)
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setCategory(Notification.CATEGORY_MESSAGE)
                          qwe1().onRecive(this, intent)

//                .addAction(R.drawable.ic_alarm,"asd",pendingIntent)
//                .addAction(R.drawable.ic_launcher_foreground, "SSSS", )


        } else {
            builder = Notification.Builder(this, CHANNEL_ID_STRING)
                .setSmallIcon(R.drawable.ic_baseline_arrow_back_24)
                .setContentTitle("TITLE2")
                .setContentText("TEXT2")
                .setContentIntent(pendingIntent)
        }

//            notificationManager.notify(NOTIFICATION_ID_INT, builder.build())
//        }
    }
    fun nott(){
        notificationManager.notify(NOTIFICATION_ID_INT, builder.build())
//        notificationManager.notify(RECEIVER_VISIBLE_TO_INSTANT_APPS, builder.build())

    }

//    fun startForeGround(){
//        var notificationIntent:Intent = Intent(this,   MainActivity
//        ::class.java)
//
//        val pendingIntent =
//            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
//
//        startForeGround(Notification.Builder(this, CHANNEL_ID_STRING)
//            .setSmallIcon(R.drawable.ic_baseline_arrow_back_24)
//            .setContentTitle("TITLE")
//            .setContentText(str)
//            .setContentIntent(pendingIntent)
//            .setVisibility(Notification.VISIBILITY_PUBLIC)
//            .setCategory(Notification.CATEGORY_MESSAGE))
//
//    }

}









