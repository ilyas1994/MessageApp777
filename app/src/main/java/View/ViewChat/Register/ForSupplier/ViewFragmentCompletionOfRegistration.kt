package View.ViewChat.Register.ForSupplier

import View.ViewChat.Register.ViewSuccesfullRegistration.FragmentSuccesfullRegistration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.example.messageapp.R
import com.example.messageapp.Router


class ViewFragmentCompletionOfRegistration : Fragment() {

    lateinit var editTelefonNumber: EditText
    lateinit var editAdress: EditText
    lateinit var buttonCompleteRegistration: Button

    private var checkEdits2 = mutableListOf<EditText>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_completion_of_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        checkEdits2.add(editAdress)
        checkEdits2.add(editTelefonNumber)
        buttonCompleteRegistration.setOnClickListener {
            funCheckEditsText2()
        }
    }

    private fun init(){
        editTelefonNumber = view?.findViewById(R.id.editTelefonNumber)!!
        editAdress = view?.findViewById(R.id.editAdress)!!
        buttonCompleteRegistration = view?.findViewById(R.id.buttonCompleteRegistration)!!
    }

    private fun funCheckEditsText2() {
        for (i in 0..checkEdits2.count() - 1) {
            if (checkEdits2[i].text.isNotEmpty()) {
                checkEdits2[i].background = ResourcesCompat.getDrawable(
                    requireActivity().resources,
                    R.drawable.register_for_supplier_design_true_filed,
                    null
                )

            } else {
                checkEdits2[i].background = ResourcesCompat.getDrawable(
                    requireActivity().resources,
                    R.drawable.register_for_supplier_design_false_filed,
                    null
                )
                Toast.makeText(context, "Заполните красные поля", Toast.LENGTH_SHORT).show()
            }
        }
        for (j in 0..checkEdits2.count() - 1) {
            if (checkEdits2[0].text.isNotEmpty() && checkEdits2[1].text.isNotEmpty()) {
                val nextFragment = Router().nextFragment(FragmentSuccesfullRegistration())
                requireActivity().supportFragmentManager.beginTransaction().apply {
                    replace(R.id.emptyFragment, nextFragment)
                    commit()
                }
            }
        }
    }

}