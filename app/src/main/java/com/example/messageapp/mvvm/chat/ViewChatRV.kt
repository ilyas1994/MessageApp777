package com.example.messageapp.mvvm.chat


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.messageapp.databinding.ViewChatRvBinding
import org.koin.android.ext.android.inject

// http://localhost:15672/api/queues/%2F/Xiaomi/
class ViewChatRV : Fragment() {
    var binding: ViewChatRvBinding? = null
    val viewModel by inject<ViewModelChat>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewChatRvBinding.inflate(inflater, container, false)
        binding?.viewModel = viewModel
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

//        recycler = view.findViewById(R.id.recyclerView)


    }
}