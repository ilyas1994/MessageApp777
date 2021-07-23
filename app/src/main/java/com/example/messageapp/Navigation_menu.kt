package com.example.messageapp

import View.ViewChat.CreateNewAppDescription.FragmentCreateNewAppDescription
import View.ViewChat.FragmentChat
import View.ViewChat.ViewCreateNewApp.FragmentCreateNewApp
import View.ViewChat.ViewCustomer.FragmentCustomer
import View.ViewChat.ViewMyNoticeForSupplier.ViewMyNoniceForSupplier
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationItemView


class Navigation_menu : Fragment() {

    lateinit var myAct: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myAct = (activity as MainActivity)
        val routerSwitchFragment = Router()
        val resetbutton: Button = view.findViewById(R.id.resetbutton)
        resetbutton.setOnClickListener {
            myAct.sharedPreferences.edit().clear().apply()
            Toast.makeText(context, "Clear", Toast.LENGTH_SHORT).show()
        }

        var nav_chat: BottomNavigationItemView = view.findViewById(R.id.nav_chat)
        var nav_myApp: BottomNavigationItemView = view.findViewById(R.id.nav_myApp)
        var nav_create_app: BottomNavigationItemView = view.findViewById(R.id.nav_create_app)
        var nav_favorite: BottomNavigationItemView = view.findViewById(R.id.nav_favorite)
        var nav_setting: BottomNavigationItemView = view.findViewById(R.id.nav_setting)


        nav_chat.setOnClickListener {
            myAct.switchFragment(FragmentChat())
        }

        nav_myApp.setOnClickListener {
            myAct.switchFragment(ViewMyNoniceForSupplier())

        }
        nav_create_app.setOnClickListener {
            myAct.switchFragment(FragmentCreateNewApp())

        }
        nav_favorite.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.emptyFragment, routerSwitchFragment.nextFragment(FragmentCreateNewAppDescription()))
                commit()
            }
        }
        nav_setting.setOnClickListener {
            myAct.switchFragment(FragmentCustomer())
        }
    }


}