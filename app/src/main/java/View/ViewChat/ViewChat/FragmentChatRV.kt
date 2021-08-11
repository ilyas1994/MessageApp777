package View.ViewChat.ViewChat


import Engine.RabbitMq.ConnectionRabbitMq
import Engine.RabbitMq.RabbitMq

import android.bluetooth.BluetoothClass

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messageapp.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.concurrent.*
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.LockSupport
import kotlin.properties.Delegates
// http://localhost:15672/api/queues/%2F/Xiaomi/
class FragmentChatRV : Fragment() {

    lateinit var buttonSendMessage: ImageView
    lateinit var TextChat: EditText
    private var adapter = ChatRecyclerView()
    lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        buttonSendMessage = view.findViewById(R.id.ivButtonSend)
        TextChat = view.findViewById(R.id.ediTextChat)

        recycler = view.findViewById(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter

        var rabbit =  RabbitMq(adapter)

         var flag = false;

            buttonSendMessage.setOnClickListener {
                recycler.scrollToPosition(adapter.itemCount)

                if (TextChat.text.isNotEmpty()) {
                    TextChat.background =
                        resources.getDrawable(R.drawable.edittextadddescription)
                    adapter.flag = true
                    ConnectionRabbitMq.sendMes= TextChat.text.toString()
                    adapter.updateList(TextChat.text.toString())

                     TextChat.text.clear()
//                    flag = false


                } else {

                    TextChat.background = resources.getDrawable(R.drawable.edittextchatisnull)
                    Toast.makeText(context, "Введите текст", Toast.LENGTH_SHORT).show()
                }
            }

        }

    val test= { mes:String ->

    }

}