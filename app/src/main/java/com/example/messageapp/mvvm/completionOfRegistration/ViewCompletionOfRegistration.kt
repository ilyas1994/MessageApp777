package com.example.messageapp.mvvm.completionOfRegistration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.messageapp.databinding.ViewCompletionOfRegistrationBinding
import org.koin.android.ext.android.inject


class ViewCompletionOfRegistration : Fragment() {

    var binding: ViewCompletionOfRegistrationBinding? = null
    val viewModel by inject<ViewModelCompleteOfRegistration>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewCompletionOfRegistrationBinding.inflate(inflater, container, false)
        binding?.viewModel = viewModel
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }




}