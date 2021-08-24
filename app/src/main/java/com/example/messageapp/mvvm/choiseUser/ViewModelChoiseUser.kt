package com.example.messageapp.mvvm.choiseUser

import com.example.messageapp.mvvm.loginPassword.ViewLoginPassword
import androidx.databinding.BaseObservable
import com.example.messageapp.AndroidInstrument.SinglInstrument

class ViewModelChoiseUser(model: ModelChoiseUser): BaseObservable() {

    fun buttonClickSupplier(){
        SinglInstrument.switchFragment(ViewLoginPassword())
    }

    fun buttonClickCustomer(){
        SinglInstrument.switchFragment(ViewLoginPassword())
    }
}