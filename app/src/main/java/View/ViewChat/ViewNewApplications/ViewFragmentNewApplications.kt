package View.ViewChat.ViewNewApplications

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messageapp.R


class ViewFragmentNewApplications : Fragment() {

    private val adapter = NewAppAdapter()
    lateinit var button: Button
     lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_new_applications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewResponseApplications)
        button = view.findViewById(R.id.buttonAdd)
        init()
    }

    private fun init(){
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        button.setOnClickListener {
            val data = DataClassAppDesc("qweq")
            adapter.addList(data)
        }

    }
}