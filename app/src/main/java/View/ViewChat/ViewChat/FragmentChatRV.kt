package View.ViewChat.ViewChat

import Engine.RabbitMq.Arr
import Engine.RabbitMq.RabbitMq
import Engine.RabbitMq.SendRabbitMQ
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

class FragmentChatRV : Fragment() {

    lateinit var buttonSendMessage: ImageView
    lateinit var TextChat: EditText
    private var adapter = ChatRecyclerView()
    lateinit var recycler: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

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
        var rabbit =  RabbitMq()
//        var sendRabbit = SendRabbitMQ()

//        if (rabbit != null) {

//        }
//        recycler = view.findViewById(R.id.recyclerView)
        recycler = view.findViewById(R.id.recyclerView)


        recycler.layoutManager = LinearLayoutManager(context)

        recycler.adapter = adapter


        rabbit.adapter = adapter

//        SendRabbitMQ.adapter = adapter



         var flag = false;


//for (i in 0..5)
//    adapter.updateList("ediTextChat.text.toString()",adapter)

            buttonSendMessage.setOnClickListener {
                if (TextChat.text.isNotEmpty()) {
                    TextChat.background =
                        resources.getDrawable(R.drawable.edittextadddescription)

//                if (flag) {



//                    adapter.flag = false
//                adapter.addDataClass(ediTextChat.text.toString())
                    adapter.updateList(TextChat.text.toString())
//
//                    SendRabbitMQ.sendMes = TextChat.text.toString()
                     TextChat.text.clear()
//                    flag = false
//                }
//                else {
//                    adapter.addDataClass(ediTextChat.text.toString())
//                    ediTextChat.text.clear()
//                    flag = true
//                }

                } else {

                    TextChat.background = resources.getDrawable(R.drawable.edittextchatisnull)
                    Toast.makeText(context, "Введите текст", Toast.LENGTH_SHORT).show()
                }
            }

        }

    val test= { mes:String ->

    }

}