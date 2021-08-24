package com.example.messageapp.mvvm.notificationForSupplier

import View.ViewChat.ViewNewApplications.NewAppAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messageapp.AndroidInstrument.SinglInstrument

class ViewModelNotificationForSupplier(model: ModelNotificationForSupplier) {
    private val adapter = NewAppAdapter()
    lateinit var recyclerView: RecyclerView

    init {
        recyclerView.layoutManager = LinearLayoutManager(SinglInstrument.showInstrument.getMainActivity())
        recyclerView.adapter = adapter
    }
    fun save(){

    }
}