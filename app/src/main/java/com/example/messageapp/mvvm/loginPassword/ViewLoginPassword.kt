package com.example.messageapp.mvvm.loginPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.messageapp.databinding.ViewLoginPasswordBinding
import org.koin.android.ext.android.inject


class ViewLoginPassword : Fragment() {

    var binding: ViewLoginPasswordBinding? = null
    private val viewModel by inject<ViewModelLoginPassword>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewLoginPasswordBinding.inflate(inflater, container, false)
        binding?.viewModel = viewModel
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }





}
