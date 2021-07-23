package com.example.messageapp

import View.ViewChat.ViewChoiseUser.FragmentChoiseUser
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class FragmentInstruction : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_instruction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageViewClose = view.findViewById<ImageView>(R.id.imageViewClose)
        imageViewClose.setOnClickListener {
//
            val nextFragment = Router().nextFragment(EmptyFragment())
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentInstruction, nextFragment)
                commit()
            }
        }
    }
}