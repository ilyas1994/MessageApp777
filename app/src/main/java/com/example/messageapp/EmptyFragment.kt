package com.example.messageapp

import View.ViewChat.ViewChoiseUser.FragmentChoiseUser
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



class EmptyFragment() : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_empty, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        switchFragment(ftt = Fragment())
    }
//    fun switchFragment(ftt: Fragment){
//        parentFragmentManager.beginTransaction().apply {
//            replace(R.id.emptyFragment, ftt)
//            commit()
//        }
//    }


}