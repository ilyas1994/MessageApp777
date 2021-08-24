package com.example.messageapp.AndroidInstrument

import android.widget.Toast
import com.example.messageapp.MainActivity

class AndroidInstrument(mainActivity: MainActivity): iInstruments {

     val mainAct: MainActivity

    init {
        this.mainAct = mainActivity
    }

    override fun toast(str: String) {
        Toast.makeText(mainAct, str, Toast.LENGTH_SHORT).show()
    }

    override fun getMainActivity(): MainActivity {
        return mainAct
    }


}