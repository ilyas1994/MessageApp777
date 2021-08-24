package View.ViewChat.Register.ForSupplier.ChoiseCity.RecyclerView

import com.example.messageapp.mvvm.completionOfRegistration.ViewCompletionOfRegistration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.messageapp.AndroidInstrument.SinglInstrument
import com.example.messageapp.R
import com.example.messageapp.Singleton.SingletonMain

class RecyclAdapter: RecyclerView.Adapter<RecyclAdapter.HolderList>() {

    var mutListAdd = mutableListOf<DataListCity>()

    class HolderList(item: View): RecyclerView.ViewHolder(item)  {
        val textViewCity = item.findViewById<TextView>(R.id.textViewCity)

        fun bind(dataListCity: DataListCity){
            textViewCity.text = dataListCity.city
            itemView.setOnClickListener {
               SingletonMain.currentIdCity = layoutPosition
                SinglInstrument.switchFragment(ViewCompletionOfRegistration())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderList {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_list_of_cities, parent, false)
        return HolderList(item)
    }

    override fun onBindViewHolder(holder: HolderList, position: Int) {
        holder.bind(mutListAdd[position])
    }

    override fun getItemCount(): Int {
        return mutListAdd.size
    }

    fun showList(dataListCity: DataListCity){
        mutListAdd.add(dataListCity)
        notifyDataSetChanged()
    }
}