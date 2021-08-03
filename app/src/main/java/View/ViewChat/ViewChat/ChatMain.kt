package View.ViewChat.ViewChat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.messageapp.R


class ChatMain(var message:MutableList<String>):RecyclerView.Adapter<ChatMain.Chat>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Chat{
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return  Chat(view)
    }

    override fun onBindViewHolder(holder: Chat, position: Int) {
       holder.firstName.text = message[position]
    }

    override fun getItemCount() = 1

    class Chat (Itemview:View):RecyclerView.ViewHolder(Itemview){
        var firstName:TextView = Itemview.findViewById(R.id.textviewIn)
    }
}

