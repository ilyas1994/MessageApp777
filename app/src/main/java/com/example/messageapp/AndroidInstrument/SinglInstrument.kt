package com.example.messageapp.AndroidInstrument

import androidx.fragment.app.Fragment
import com.example.messageapp.MainActivity
import com.example.messageapp.R

object SinglInstrument {

    lateinit var showInstrument: iInstruments

    fun setInstrument(showInstrument: iInstruments){
        this.showInstrument = showInstrument
    }

    fun switchFragment(ft: Fragment){
        showInstrument.getMainActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.emptyFragment, ft)
            commit()
        }
    }
}