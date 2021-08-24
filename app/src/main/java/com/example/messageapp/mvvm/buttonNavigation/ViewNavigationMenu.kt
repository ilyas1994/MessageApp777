package com.example.messageapp.mvvm.buttonNavigation

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.adapters.AdapterViewBindingAdapter.setOnItemSelectedListener
import androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter.setOnItemSelectedListener
import androidx.fragment.app.Fragment
import com.example.messageapp.databinding.ViewMainWindowBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.ext.android.inject


class DataBindingAdapter { // any name is fine
}

class ViewNavigationMenu : Fragment() {
       var binding:ViewMainWindowBinding? = null
       val viewModel by inject<ViewModelNavigationMenu> ()
    //  private lateinit var myAct: MainActivity
//  private lateinit var nav_chat: BottomNavigationItemView
//  private lateinit var nav_myApp: BottomNavigationItemView
//  private lateinit var nav_create_app: BottomNavigationItemView
//  private lateinit var nav_favorite: BottomNavigationItemView
//  private lateinit var nav_setting: BottomNavigationItemView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        class DataBindingAdapter { // any name is fine
        }

        binding = ViewMainWindowBinding.inflate(inflater, container, false)
        binding?.viewModel = viewModel

            return binding?.root
        // Inflate the layout for this fragment
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        findview()

//        nav_chat.setOnClickListener {
//            replaceFragment(FragmentChatRV())
//        }
//        nav_myApp.setOnClickListener {
//            replaceFragment(ViewFragmentNewApplications())
//        }
//        nav_create_app.setOnClickListener {
//            replaceFragment(FragmentCreateNewApp())
//        }
//        nav_favorite.setOnClickListener {
//            replaceFragment(ViewChoiseCity())
////            Toast.makeText(context, "THISSSS", Toast.LENGTH_SHORT).show()
//        }
//        nav_setting.setOnClickListener {
//            replaceFragment(FragmentCustomerSetting())
//        }

//        myAct = (activity as MainActivity)
//        val resetbutton: Button = view.findViewById(R.id.resetbutton)
//        resetbutton.setOnClickListener {
//            myAct.sharedPreferences.edit().clear().apply()
//            SinglInstrument.showInstrument.toast("Clear")
//        }
    }

//    private fun replaceFragment(ft: Fragment){
//        requireActivity().supportFragmentManager.beginTransaction().apply {
//            replace(R.id.buttomNavMenu, ft)
//            addToBackStack(null)
//            commit()
//        }
//    }

//    private fun findview(){
//        nav_chat = view?.findViewById(R.id.nav_chat)!!
//        nav_myApp = view?.findViewById(R.id.nav_myApp)!!
//        nav_create_app = view?.findViewById(R.id.nav_create_app)!!
//        nav_favorite = view?.findViewById(R.id.nav_favorite)!!
//        nav_setting = view?.findViewById(R.id.nav_setting)!!
//    }
}