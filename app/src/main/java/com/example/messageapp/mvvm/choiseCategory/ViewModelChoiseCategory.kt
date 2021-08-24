package com.example.messageapp.mvvm.choiseCategory

import androidx.databinding.BaseObservable
import com.example.messageapp.AndroidInstrument.SinglInstrument
import com.example.messageapp.mvvm.buttonNavigation.ViewNavigationMenu

class ViewModelChoiseCategory(model: ModelChoiseCategory): BaseObservable() {

    fun buttonSave(){
      SinglInstrument.switchFragment(ViewNavigationMenu())
    }
}