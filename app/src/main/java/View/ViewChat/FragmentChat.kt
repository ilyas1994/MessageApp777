package View.ViewChat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.messageapp.R


class FragmentChat : Fragment() {

    private lateinit var ln: LinearLayout
    private lateinit var IncommingMessage: TextView
    private lateinit var textViewOutGoingMessage: TextView
    private lateinit var editTextMessage: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }
//qwe
    // start
    //start22
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        IncommingMessage = view.findViewById(R.id.IncommingMessage)
        textViewOutGoingMessage = view.findViewById(R.id.textViewOutGoingMessage)
         editTextMessage = view.findViewById(R.id.editTextMessage)

        var buttonSendMessage: ImageView = view.findViewById(R.id.buttonSendMessage)
         ln = view.findViewById(R.id.ln)
        var flag = false;

        buttonSendMessage.setOnClickListener {
            if(!flag) {
                dymanicMessage(textViewOutGoingMessage)
                flag = true
            }else{
                dymanicMessage(IncommingMessage)
                flag = false
            }
            editTextMessage.text.clear()


        }


    }

    private fun dymanicMessage(textV:TextView){
        var dynamicTextViewOutGoingMessage = TextView(context)
        dynamicTextViewOutGoingMessage.layoutParams = textV.layoutParams
        dynamicTextViewOutGoingMessage.text = editTextMessage.text
        dynamicTextViewOutGoingMessage.background = textV.background
        dynamicTextViewOutGoingMessage.gravity = textV.gravity
        dynamicTextViewOutGoingMessage.visibility = View.VISIBLE
        dynamicTextViewOutGoingMessage.setTextColor(textV.textColors)
        ln.addView(dynamicTextViewOutGoingMessage)
    }


}