package com.example.messageapp.AndroidInstrument

import com.example.messageapp.MainActivity

interface iInstruments {

    fun toast(str: String)

    fun getMainActivity(): MainActivity
}