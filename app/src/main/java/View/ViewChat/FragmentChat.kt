package View.ViewChat

import View.ViewChat.ViewCreateNewApp.FragmentCreateNewApp
import View.ViewChat.ViewCustomer.FragmentCustomer
import View.ViewChat.ViewMyNoticeForSupplier.ViewMyNoniceForSupplier
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginTop
import com.example.messageapp.MainActivity
import com.example.messageapp.Navigation_menu
import com.example.messageapp.R
import com.google.android.material.bottomnavigation.BottomNavigationItemView


class FragmentChat : Fragment() {

    lateinit var ln: LinearLayout
    lateinit var IncommingMessage: TextView
    lateinit var textViewOutGoingMessage: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        IncommingMessage = view.findViewById(R.id.IncommingMessage)
        textViewOutGoingMessage = view.findViewById(R.id.textViewOutGoingMessage)
        var editTextMessage: EditText = view.findViewById(R.id.editTextMessage)
        var buttonSendMessage: ImageView = view.findViewById(R.id.buttonSendMessage)
         ln = view.findViewById(R.id.ln)
        var flag = false;

        buttonSendMessage.setOnClickListener {
//            textViewIncommingMessage.text = "${textViewIncommingMessage.text}  \n ${editTextMessage.text} "
//            editTextMessage.setText("")
            if(!flag) {
                dymanicMessage(textViewOutGoingMessage)
                flag = true
            }else{
                dymanicMessage(IncommingMessage)
                flag = false
            }


        }


        var myAct = (activity as MainActivity)
        var nav_chat: BottomNavigationItemView = view.findViewById(R.id.nav_chat)
        var nav_myApp: BottomNavigationItemView = view.findViewById(R.id.nav_myApp)
        var nav_create_app: BottomNavigationItemView = view.findViewById(R.id.nav_create_app)
        var nav_favorite: BottomNavigationItemView = view.findViewById(R.id.nav_favorite)
        var nav_setting: BottomNavigationItemView = view.findViewById(R.id.nav_setting)

        nav_chat.setOnClickListener {
            myAct.switchFragment(FragmentChat())
        }

        nav_myApp.setOnClickListener {
            myAct.switchFragment(ViewMyNoniceForSupplier())

        }
        nav_create_app.setOnClickListener {
            myAct.switchFragment(FragmentCreateNewApp())

        }
        nav_favorite.setOnClickListener {

        }
        nav_setting.setOnClickListener {
            myAct.switchFragment(FragmentCustomer())

        }
    }

    private fun dymanicMessage(textV:TextView){
        var dynamicTextViewOutGoingMessage = TextView(context)
        dynamicTextViewOutGoingMessage.layoutParams = textV.layoutParams
        dynamicTextViewOutGoingMessage.text = "New MESSAGE"
        dynamicTextViewOutGoingMessage.background = textV.background
        dynamicTextViewOutGoingMessage.gravity = textV.gravity
        dynamicTextViewOutGoingMessage.visibility = View.VISIBLE
        dynamicTextViewOutGoingMessage.setTextColor(textV.textColors)
        ln.addView(dynamicTextViewOutGoingMessage)
    }


}