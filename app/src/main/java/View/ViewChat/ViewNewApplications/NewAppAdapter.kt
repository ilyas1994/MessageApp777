package View.ViewChat.ViewNewApplications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.messageapp.R

class NewAppAdapter: RecyclerView.Adapter<NewAppAdapter.AppDescHolder>() {

    val addlist = ArrayList<DataClassAppDesc>()
    class AppDescHolder(item: View): RecyclerView.ViewHolder(item) {
        var incommingMess: TextView =  item.findViewById(R.id.incommingAppTextView)

        fun bind(dataClassAppDesc: DataClassAppDesc){
            incommingMess.text = dataClassAppDesc.textview
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppDescHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_new_applications, parent, false)
        return AppDescHolder(view)
    }

    override fun onBindViewHolder(holder: AppDescHolder, position: Int) {
        holder.bind(addlist[position])
    }

    override fun getItemCount(): Int {
        return addlist.size
    }

    fun addList(dataClassAppDesc: DataClassAppDesc){
        addlist.add(dataClassAppDesc)
        notifyDataSetChanged()
    }
}
