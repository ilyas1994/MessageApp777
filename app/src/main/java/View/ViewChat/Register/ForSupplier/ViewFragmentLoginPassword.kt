package View.ViewChat.Register.ForSupplier

import View.ViewChat.CreateNewDescription.FragmentCreateNewDescription
import View.ViewChat.Register.ViewChoiseUser.FragmentChoiseUser
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.messageapp.EmptyFragment
import com.example.messageapp.MainActivity
import com.example.messageapp.R
import com.example.messageapp.Router


class ViewFragmentLoginPassword : Fragment() {

    private lateinit var editTextEnterTelefor: EditText
    private lateinit var editTextEnterPassword: EditText
    private lateinit var buttonSaveLoginPassword: Button
    private lateinit var myActv: MainActivity
    private var checkEdits = mutableListOf<EditText>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_login_password, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        myActv = (activity as MainActivity)

        checkEdits.add(editTextEnterPassword)
        checkEdits.add(editTextEnterTelefor)

        buttonSaveLoginPassword.setOnClickListener {
            checkEditsText()

        }

    }

    private fun checkEditsText() {

        for (i in 0..checkEdits.count() - 1) {
            if (checkEdits[i].text.isNotEmpty()) {
                checkEdits[i].background = ResourcesCompat.getDrawable(
                    requireActivity().resources,
                    R.drawable.register_for_supplier_design_true_filed,
                    null
                )

            } else {
                checkEdits[i].background = ResourcesCompat.getDrawable(
                    requireActivity().resources,
                    R.drawable.register_for_supplier_design_false_filed,
                    null
                )
                Toast.makeText(context, "Заполните красные поля", Toast.LENGTH_SHORT).show()
            }
        }
        for (j in 0..checkEdits.count() - 1) {
            if (checkEdits[0].text.isNotEmpty() && checkEdits[1].text.isNotEmpty()) {
                var nextFragmenter = Router().nextFragment(ViewFragmentChoiseCategory())
                requireActivity().supportFragmentManager.beginTransaction().apply {
                    replace(R.id.emptyFragment, nextFragmenter, null)
                    commit()
                }
            }

        }

    }

    private fun init() {
        editTextEnterTelefor = view?.findViewById(R.id.editTextEnterTelefor)!!
        editTextEnterPassword = view?.findViewById(R.id.editTextEnterPassword)!!
        buttonSaveLoginPassword = view?.findViewById(R.id.buttonSaveLoginPassword)!!

    }

}
