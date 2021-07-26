package View.ViewChat.ViewCreateNewApp

import View.ViewChat.FragmentChat
import View.ViewChat.ViewCustomer.FragmentCustomer
import View.ViewChat.ViewMyNoticeForSupplier.ViewMyNoniceForSupplier
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.messageapp.MainActivity
import com.example.messageapp.R
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import companion.ExchangeName


class FragmentCreateNewApp : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_new_app, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var mainAct = (activity as MainActivity)
        var radio1: RadioButton = view.findViewById(R.id.radio1)
        var radio2: RadioButton = view.findViewById(R.id.radio2)
        var buttonSave: Button = view.findViewById(R.id.buttonSave)
        var radioGroup: RadioGroup = view.findViewById(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
                radio1.setOnClickListener {
                    ExchangeName.name = "telefon"
                }
                radio2.setOnClickListener {
                    ExchangeName.name = "forhome"
                }
        }
        buttonSave.setOnClickListener {

        }

    }
}