package com.example.messageapp.mvvm.buttonNavigation

import android.view.MenuItem
import com.example.messageapp.R


class ViewModelNavigationMenu() {
    fun onBottomMenuClicked(item: MenuItem): Boolean {
        when (item.itemId) {
            0 ->{
                println("0")

                return true
            }
           1 ->{
                println("1")
                return true
            }
        }
        return false
    }
//    fun OpenChat(){
//
//    }
//
//    fun  OpenMyRequest(){
//
//    }
//
//    fun OpenCreateRequest(){
//
//    }
//
//    fun OpenFavorite(){
//
//    }
//
//    fun OpenSetting(){
//
//    }
}