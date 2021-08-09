package View.ViewChat.Register.ViewChoiseUser

import View.ViewChat.Register.ForSupplier.ViewFragmentLoginPassword
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.messageapp.*

class FragmentChoiseUser : Fragment() {
   private lateinit var imageViewCustomer: ImageView
   private lateinit var imageViewProvider: ImageView
   private lateinit var myActt: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choise_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         myActt = (activity as MainActivity)
        imageViewCustomer = view.findViewById(R.id.imageViewCustomer)
        imageViewProvider = view.findViewById(R.id.imageViewProvider)
        imageViewProvider.setOnClickListener {
            val nextFragmentChoiseLoginPassword = Router().nextFragment(ViewFragmentLoginPassword())
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.emptyFragment, nextFragmentChoiseLoginPassword)
                commit()
            }
//            myActt.switchFragment(Co)

        }



    }
}

