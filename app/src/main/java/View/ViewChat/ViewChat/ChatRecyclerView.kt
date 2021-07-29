package View.ViewChat.ViewChat

import android.app.ActionBar
import android.content.Context
import android.text.Layout
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.messageapp.R

class ChatRecyclerView: RecyclerView.Adapter<ChatRecyclerView.ChatHolder>() {

    var addlist = ArrayList<String>()
    var addlistParams = ArrayList<LinearLayout.LayoutParams>()
     var flag = false

    class ChatHolder(item: View): RecyclerView.ViewHolder(item) {


   var it = item
        fun bind(dataClassChat: String, t:LinearLayout.LayoutParams){
            var textview1 = it.findViewById<TextView>(R.id.textviewIn)
            textview1.layoutParams = t
            if(t.gravity == Gravity.LEFT)
                textview1.setPadding(10,0,0,0)
            else if(t.gravity == Gravity.RIGHT)
                textview1.setPadding(0,0,10,0)

            textview1.text = dataClassChat
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)

        var params =  LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        if(flag) {
            params.gravity = Gravity.RIGHT
            flag = false
        }
        else {
            params.gravity = Gravity.LEFT
            flag = true
        }

        addlistParams.add(params)
        return ChatHolder(view)
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        holder.bind(addlist[position], addlistParams[position])
    }

    override fun getItemCount(): Int {
        return addlist.size
    }

//    fun addDataClass(dataClassChat: DataClassChat){
    fun addDataClass(dataClassChat: String){

        addlist.add(dataClassChat)
        notifyDataSetChanged()
    }
}