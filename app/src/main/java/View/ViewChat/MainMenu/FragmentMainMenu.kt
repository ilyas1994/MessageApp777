package View.ViewChat.MainMenu

import View.ViewChat.FragmentChat
import View.ViewChat.ViewCreateNewApp.FragmentCreateNewApp
import View.ViewChat.ViewCustomer.FragmentCustomer
import View.ViewChat.ViewMyNoticeForSupplier.ViewMyNoniceForSupplier
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.messageapp.MainActivity
import com.example.messageapp.R


class FragmentMainMenu : Fragment() {

    lateinit var imageViewNewApp: ImageView
    lateinit var imageViewChat: ImageView
    lateinit var imageViewSetting: ImageView
    lateinit var createNewApp: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var mainAct = (activity as MainActivity)
        imageViewNewApp = view.findViewById(R.id.imageViewNewApp)
        imageViewChat = view.findViewById(R.id.imageViewChat)
        imageViewSetting = view.findViewById(R.id.imageViewSetting)
        createNewApp = view.findViewById(R.id.createNewApp)
        imageViewNewApp.setOnClickListener {
            mainAct.switchFragment(ViewMyNoniceForSupplier())
        }
        imageViewChat.setOnClickListener {
            mainAct.switchFragment(FragmentChat())
        }
        imageViewSetting.setOnClickListener {
            mainAct.switchFragment(FragmentCustomer())
        }
        createNewApp.setOnClickListener {
            mainAct.switchFragment(FragmentCreateNewApp())
        }
    }
}