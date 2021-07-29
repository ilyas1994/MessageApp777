package View.ViewChat.ViewCustomer

import View.ViewChat.ViewSuccesfullRegistration.FragmentSuccesfullRegistration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import com.example.messageapp.MainActivity
import com.example.messageapp.R


class FragmentCustomer : Fragment() {

    lateinit var textViewChoiseProductSelected: TextView
    lateinit var checkboxVegetables: CheckBox
    lateinit var checkboxMeat: CheckBox
    lateinit var checkboxFruits: CheckBox
    lateinit var buttonSaveCheckBox: Button
    lateinit var myAct: MainActivity
    private var mutableListAdd = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindByiD()
        myAct = (activity as MainActivity)
        choiseCheckBox()


    }

    fun choiseCheckBox() {
        checkboxVegetables.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                mutableListAdd.add("Овощи")
            }
        }
        checkboxMeat.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                mutableListAdd.add("Мясо")
        }
    }
        buttonSaveCheckBox.setOnClickListener {
                textViewChoiseProductSelected.text = mutableListAdd.toString()
            Toast.makeText(context, "Сохранено", Toast.LENGTH_SHORT).show()
            myAct.switchFragment(FragmentSuccesfullRegistration())
        }
    }


    private fun bindByiD(){
        textViewChoiseProductSelected = view?.findViewById(R.id.textViewChoiseProductSelected)!!
        checkboxVegetables = view?.findViewById(R.id.checkboxVegetables)!!
        buttonSaveCheckBox = view?.findViewById(R.id.buttonSaveCheckBox)!!
        checkboxMeat = view?.findViewById(R.id.checkboxMeat)!!
        checkboxFruits = view?.findViewById(R.id.checkboxFruits)!!
    }

}