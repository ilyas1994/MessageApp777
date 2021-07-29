package View.ViewChat.ViewChat

import Engine.RabbitMq.RabbitMq
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


class FragmentChatRV : Fragment() {

    lateinit var buttonSendMessage: ImageView
    lateinit var ediTextChat: EditText
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
        var rabbit = context?.let { RabbitMq("test", it) }
        if (rabbit != null) {
            rabbit.createConnection()
            RabbitMq.adapter = adapter
        }
        recycler = view.findViewById(R.id.recyclerView)
        buttonSendMessage = view.findViewById(R.id.ivButtonSend)
        ediTextChat = view.findViewById(R.id.ediTextChat)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter

         var flag = false;
       


        buttonSendMessage.setOnClickListener {
            if (ediTextChat.text.isNotEmpty()) {
                ediTextChat.background = resources.getDrawable(R.drawable.edittextadddescription)

//                if (flag) {
                    adapter.flag = false
                    adapter.addDataClass(ediTextChat.text.toString())
                    ediTextChat.text.clear()
                    RabbitMq.sendMes = ediTextChat.text.toString()

//                    flag = false
//                }
//                else {
//                    adapter.addDataClass(ediTextChat.text.toString())
//                    ediTextChat.text.clear()
//                    flag = true
//                }

            } else {
                ediTextChat.background = resources.getDrawable(R.drawable.edittextchatisnull)
                Toast.makeText(context, "Введите текст", Toast.LENGTH_SHORT).show()
            }
        }
    }
}