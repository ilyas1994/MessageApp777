package com.example.messageapp.mvvm.notificationForSupplier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.messageapp.databinding.ViewNotificationForSupplierBinding
import org.koin.android.ext.android.inject


class ViewNotificationForSupplier : Fragment() {

    var bining: ViewNotificationForSupplierBinding? = null
    val viewModel by inject<ViewModelNotificationForSupplier>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bining = ViewNotificationForSupplierBinding.inflate(inflater, container, false)
        bining?.viewModel = viewModel
        return bining?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init(){


//        button.setOnClickListener {
//            val data = DataClassAppDesc("qweq")
//            adapter.addList(data)
//        }

    }
}