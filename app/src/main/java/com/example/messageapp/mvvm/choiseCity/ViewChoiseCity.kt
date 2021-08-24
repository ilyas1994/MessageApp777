package com.example.messageapp.mvvm.choiseCity

import View.ViewChat.Register.ForSupplier.ChoiseCity.ParseApiBranchDataKz.startParsingJson
import View.ViewChat.Register.ForSupplier.ChoiseCity.RecyclerView.DataListCity
import View.ViewChat.Register.ForSupplier.ChoiseCity.RecyclerView.RecyclAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messageapp.R
import com.example.messageapp.Singleton.SingletonMain


class ViewChoiseCity : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view_choise_city, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var startParsingJson = startParsingJson()
        startParsingJson.parseBranch()

        var recyclerV = view.findViewById<RecyclerView>(R.id.recyclerVChoiseCity)

        var adapter = RecyclAdapter()
        recyclerV.adapter = adapter
        recyclerV.layoutManager = LinearLayoutManager(context)
        for (i in 0..SingletonMain.mutlistParse.count() - 1){
            var listcity = DataListCity("${SingletonMain.mutlistParse[i]}")
            adapter.showList(listcity)
        }

    }
}