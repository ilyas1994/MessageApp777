package View.ViewChat.ViewChoiseUser

import View.ViewChat.ViewCustomer.FragmentCustomer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.messageapp.FragmentInstruction
import com.example.messageapp.MainActivity
import com.example.messageapp.R
import com.example.messageapp.Router

class FragmentChoiseUser : Fragment() {
    lateinit var buttonInstruction: Button
    lateinit var imageViewCustomer: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choise_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var mainActivity = (activity as MainActivity)
        buttonInstruction = view.findViewById(R.id.buttonInstruction)
        imageViewCustomer = view.findViewById(R.id.imageViewCustomer)
        buttonInstruction.setOnClickListener {

            val nextFragment = Router().nextFragment(FragmentInstruction())
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentInstruction, nextFragment)
                commit()
            }
        }
        imageViewCustomer.setOnClickListener {
            mainActivity.switchFragment(FragmentCustomer())

        }
    }

}

