package View.ViewChat.ViewMyNoticeForSupplier

import View.ViewChat.FragmentChat
import View.ViewChat.ViewChoiseUser.FragmentChoiseUser
import View.ViewChat.ViewCreateNewApp.FragmentCreateNewApp
import View.ViewChat.ViewCustomer.FragmentCustomer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.messageapp.MainActivity
import com.example.messageapp.R
import com.google.android.material.bottomnavigation.BottomNavigationItemView


class ViewMyNoniceForSupplier : Fragment() {
    lateinit var mainAct: MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_my_nonice_for_supplier, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainAct = (activity as MainActivity)
        val imageviewButtonBack: ImageView = view.findViewById(R.id.imageviewButtonBack)
        imageviewButtonBack.setOnClickListener {
            mainAct.switchFragment(FragmentChoiseUser())

        }

    }
}