package com.example.messageapp.mvvm.createRequest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.messageapp.databinding.ViewCreateRequestBinding
import org.koin.android.ext.android.inject


class ViewCreateRequest : Fragment() {

    var binding: ViewCreateRequestBinding? = null
    val viewModel by inject<ViewModelCreateRequest>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewCreateRequestBinding.inflate(inflater, container, false)
        binding?.viewModel = viewModel
        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        var mainAct = (activity as MainActivity)

//        radioGroup.setOnCheckedChangeListener { group, checkedId ->
//                radio1.setOnClickListener {
//                    ExchangeName.name = "telefon"
//                }
//                radio2.setOnClickListener {
//                    ExchangeName.name = "forhome"
//                }
//        }
//        buttonSave.setOnClickListener {
//
//        }

    }
}