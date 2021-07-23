package ViewDescriptionApplication

import RabbitMqConnect.RabbitMq
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.messageapp.R
import companion.message

class FragmentDescriptionApplication : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var rabbitThread = RabbitMq()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description_application, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var sendButton = view.findViewById<Button>(R.id.buttonSend)
        var messageEditText:EditText = view.findViewById(R.id.editTextApp)
        var messageText:TextView = view.findViewById(R.id.textViewDialogiMessage)

        sendButton.setOnClickListener {
            message.mes = messageEditText.text.toString()
            messageText.text = "${messageText.text} ${messageEditText.text} \n"
        }
    }
}