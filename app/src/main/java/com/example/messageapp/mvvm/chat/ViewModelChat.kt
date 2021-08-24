package com.example.messageapp.mvvm.chat

import View.ViewChat.ViewChat.ChatRecyclerView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messageapp.AndroidInstrument.SinglInstrument

class ViewModelChat(modelChat: ModelChat): ViewModel() {

    private var adapter = ChatRecyclerView()
    lateinit var recycler: RecyclerView

    init {

        recycler.layoutManager = LinearLayoutManager(SinglInstrument.showInstrument.getMainActivity())
        recycler.adapter = adapter
    }


    var editTextMessage = ""

    fun sendMessage(){


//        var rabbit =  RabbitMq(adapter)
//
//        var flag = false;
//
//            recycler.scrollToPosition(adapter.itemCount)
//
//            if (TextChat.text.isNotEmpty()) {
//                TextChat.background =
//                    resources.getDrawable(R.drawable.edittextadddescription)
//                adapter.flag = true
//                ConnectionRabbitMq.sendMes= TextChat.text.toString()
//                adapter.updateList(TextChat.text.toString())
//
//                TextChat.text.clear()
////                    flag = false
//
//
//            } else {
//
//                TextChat.background = resources.getDrawable(R.drawable.edittextchatisnull)
//                Toast.makeText(context, "Введите текст", Toast.LENGTH_SHORT).show()
//            }
//


    }
}