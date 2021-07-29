package com.example.messageapp

import View.ViewChat.CreateNewAppDescription.FragmentCreateNewAppDescription
import View.ViewChat.FragmentChat
import View.ViewChat.ViewChat.ChatRecyclerView
import View.ViewChat.ViewChat.FragmentChatRV
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
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarItemView


class Navigation_menu : Fragment() {

    lateinit var myAct: MainActivity
    lateinit var nav_chat: BottomNavigationItemView
    lateinit var nav_myApp: BottomNavigationItemView
    lateinit var nav_create_app: BottomNavigationItemView
    lateinit var nav_favorite: BottomNavigationItemView
    lateinit var nav_setting: BottomNavigationItemView

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

//        replaceFragment(ViewMyNoniceForSupplier())
        findview()


        nav_chat.setOnClickListener {
            replaceFragment(FragmentChat())
        }
        nav_myApp.setOnClickListener {
            replaceFragment(ViewMyNoniceForSupplier())
        }
        nav_create_app.setOnClickListener {
            replaceFragment(FragmentCreateNewApp())
        }
        nav_favorite.setOnClickListener {
            replaceFragment(FragmentChatRV())

        }
        nav_setting.setOnClickListener {
            replaceFragment(FragmentCustomer())
        }

        myAct = (activity as MainActivity)
        val resetbutton: Button = view.findViewById(R.id.resetbutton)
        resetbutton.setOnClickListener {
            myAct.sharedPreferences.edit().clear().apply()
            Toast.makeText(context, "Clear", Toast.LENGTH_SHORT).show()
        }



    }
    private fun replaceFragment(ft: Fragment){
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.emptyFragment, ft, null)
            addToBackStack(null)
            commit()
        }
    }

    private fun findview(){
        nav_chat = view?.findViewById(R.id.nav_chat)!!
        nav_myApp = view?.findViewById(R.id.nav_myApp)!!
        nav_create_app = view?.findViewById(R.id.nav_create_app)!!
        nav_favorite = view?.findViewById(R.id.nav_favorite)!!
        nav_setting = view?.findViewById(R.id.nav_setting)!!
    }
}