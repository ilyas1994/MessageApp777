package com.example.messageapp.mvvm.succesfullRegistration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.messageapp.MainActivity
import com.example.messageapp.R
import com.example.messageapp.databinding.ViewSuccesfullRegistrationBinding
import org.koin.android.ext.android.inject


class ViewSuccesfullRegistration : Fragment() {

    var binding: ViewSuccesfullRegistrationBinding? = null
    val viewModel by inject<ViewModelSuccesfullRegistration>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewSuccesfullRegistrationBinding.inflate(inflater, container, false)
        binding?.viewModel = viewModel
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonSuccesfullRegistration: Button = view.findViewById(R.id.buttonSuccesfullRegistration)
        var mainAct = (activity as MainActivity)
        var counter = 0

        buttonSuccesfullRegistration.setOnClickListener {
            counter = 1
            if (counter == 1){
                mainAct.sharedSave(true)
            }
        }
    }
}