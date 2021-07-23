package View.ViewChat.ViewSuccesfullRegistration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.messageapp.MainActivity
import com.example.messageapp.Navigation_menu
import com.example.messageapp.R


class FragmentSuccesfullRegistration : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_succesfull_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonSuccesfullRegistration: Button = view.findViewById(R.id.buttonSuccesfullRegistration)
        var mainAct = (activity as MainActivity)
        var counter = 0

        buttonSuccesfullRegistration.setOnClickListener {
            counter = 1
            if (counter == 1){
                mainAct.sharedSave(true)
            }
        }
    }
}