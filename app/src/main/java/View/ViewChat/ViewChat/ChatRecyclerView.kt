package View.ViewChat.ViewChat

import Engine.RabbitMq.IRecyclerViewDispatchUpdatesTo
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.messageapp.R





class ChatRecyclerView: RecyclerView.Adapter<ChatRecyclerView.ChatHolder>(), IRecyclerViewDispatchUpdatesTo {

    var addlist = mutableListOf<String>()
    var NewAddlist = mutableListOf<String>()

    var addlistParams = ArrayList<LinearLayout.LayoutParams>()

     var SendOrReciveType:IRecyclerViewDispatchUpdatesTo.Type = IRecyclerViewDispatchUpdatesTo.Type.send

                class ChatHolder(item: View,  var CV:ChatRecyclerView): RecyclerView.ViewHolder(item) {


                    var it = item

                            fun bind(dataClassChat: String){
//                    fun bind(dataClassChat: String) {
                             var textview1 = it.findViewById<TextView>(R.id.textviewIn)

//                                            textview1.layoutParams = t
//
//                                             if(t.gravity == Gravity.LEFT){
//                                                 textview1.setPadding(10, 0, 0, 0)
//                                             }else if(t.gravity == Gravity.RIGHT){
//                                                 textview1.setPadding(0, 0, 10, 0)
//                                             }
//
//                        println( textview1.gravity);
                                    textview1.text = dataClassChat
                    }
                }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)

//        var params =  LinearLayout.LayoutParams(
//            LinearLayout.LayoutParams.WRAP_CONTENT,
//            LinearLayout.LayoutParams.WRAP_CONTENT
//        )
//
//        if(SendOrReciveType == IRecyclerViewDispatchUpdatesTo.Type.recive) {
//            params.gravity = Gravity.RIGHT
//
//        }
//
//        if(SendOrReciveType == IRecyclerViewDispatchUpdatesTo.Type.send) {
//            params.gravity = Gravity.LEFT
//
//        }
//
//        addlistParams.add(params)
        return ChatHolder(view,this)
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        holder.bind(addlist[position])

//        holder.bind(addlist[position])
    }

    override fun getItemCount(): Int {
        return addlist.size
    }

//    fun addDataClass(dataClassChat: DataClassChat){
//    fun addDataClass(dataClassChat: String){
//
//        flag = false
//        addlist.add(dataClassChat)
////        notifyDataSetChanged()
//
//
//    }



        class  MyDiffCallBack(mutListNew: ArrayList<String>, mutListOld:ArrayList<String>): DiffUtil.Callback() {
            var old = ArrayList<String>()

            var new = ArrayList<String>()

               init {
                   old = mutListOld
                   new = mutListNew
               }
            override fun getOldListSize(): Int {
                return old.count();
            }

            override fun getNewListSize(): Int {
                return new.count();
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return old.get(oldItemPosition) == new.get(newItemPosition)
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldProduct: String = old.get(oldItemPosition)
                val newProduct: String = new.get(newItemPosition)
                return oldProduct == newProduct
            }

            override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
                //you can return particular field for changed item.
                return super.getChangePayload(oldItemPosition, newItemPosition)
            }

        }


    override fun updateList(s:String, SendOrReciveType:IRecyclerViewDispatchUpdatesTo.Type) {
         this.SendOrReciveType = SendOrReciveType
         NewAddlist.add(s)

        var diffResult = DiffUtil.calculateDiff(MyDiffCallBack(NewAddlist as ArrayList<String>, this.addlist as ArrayList<String>),false)
        addlist.clear()
        addlist.addAll(NewAddlist)
        diffResult.dispatchUpdatesTo(this)

    }



}