package com.example.messageapp

import Engine.RabbitMq.ConnectionRabbitMq
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Parcel
import android.os.Parcelable

abstract class QWE: BroadcastReceiver() {
    fun onRecive(context: Context, intent: Intent){
    }
}
class qwe1: QWE() {




    override fun onReceive(context: Context?, intent: Intent?) {
//        ConnectionRabbitMq.mainAct.nott()

    }

}