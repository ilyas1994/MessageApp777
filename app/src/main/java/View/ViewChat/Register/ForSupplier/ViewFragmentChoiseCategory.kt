package View.ViewChat.Register.ForSupplier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.messageapp.EmptyFragment
import com.example.messageapp.MainActivity
import com.example.messageapp.R
import com.example.messageapp.Router


class ViewFragmentChoiseCategory : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_choise_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonSaveCategory: Button = view.findViewById(R.id.buttonSaveCategory)

        buttonSaveCategory.setOnClickListener {
            val nextFragment = Router().nextFragment(ViewFragmentCompletionOfRegistration())
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.emptyFragment, nextFragment, null)
                commit()
            }
        }
    }
}