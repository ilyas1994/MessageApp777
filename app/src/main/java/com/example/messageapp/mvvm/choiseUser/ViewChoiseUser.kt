package com.example.messageapp.mvvm.choiseUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.messageapp.databinding.ViewChoiseUserBinding
import org.koin.android.ext.android.inject

class ViewChoiseUser : Fragment() {

    private var binding: ViewChoiseUserBinding? = null
    private val viewModel by inject<ViewModelChoiseUser>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewChoiseUserBinding.inflate(inflater, container, false)
        binding?.viewModel = viewModel
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        }



    }


