package View.ViewChat.ViewChat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messageapp.R


class FragmentChatRV : Fragment() {

    lateinit var button: Button
    private var adapter = ChatRecyclerView()
    lateinit var recycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.recyclerView)
        button = view.findViewById(R.id.button)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter
         var flag = false;
        button.setOnClickListener {
            if(flag) {
                adapter.addDataClass("Frist")
                flag = false
            }
            else {
                adapter.addDataClass("Second")
                flag = true
            }

        }
    }
}