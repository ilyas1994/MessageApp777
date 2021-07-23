package View.ViewChat.CreateNewAppDescription

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.messageapp.R


class FragmentCreateNewAppDescription : Fragment() {

    private lateinit var mainLinear: LinearLayout
    private lateinit var linearCreateNewApp: LinearLayout
    private lateinit var dynamiceditTextPosition: EditText
    private lateinit var imageviewNewLinear: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_new_app_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainLinear = view.findViewById(R.id.mainLinear)
        linearCreateNewApp = view.findViewById(R.id.linearCreateNewApp)
        dynamiceditTextPosition = view.findViewById(R.id.dynamiceditTextPosition)
        imageviewNewLinear = view.findViewById(R.id.imageviewNewLinear)

        imageviewNewLinear.setOnClickListener {
            dynamicCreateEdit()
        }
    }

    private fun dynamicCreateEdit(){
        var linearCreate = LinearLayout(context)
        linearCreate.layoutParams = linearCreateNewApp.layoutParams

        var editTextCreate = EditText(context)
        editTextCreate.layoutParams = dynamiceditTextPosition.layoutParams
        editTextCreate.hint = dynamiceditTextPosition.hint
        editTextCreate.background = dynamiceditTextPosition.background
        editTextCreate.setPadding(20,0,0,0)



        linearCreate.addView(editTextCreate)
        mainLinear.addView(linearCreate)
//        mainLinear.addView(imageviewNewLinear)

    }
}