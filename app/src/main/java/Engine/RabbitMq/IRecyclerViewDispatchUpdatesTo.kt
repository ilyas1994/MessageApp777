package Engine.RabbitMq

import View.ViewChat.ViewChat.ChatRecyclerView

interface IRecyclerViewDispatchUpdatesTo {
    enum class Type{
        send,recive
    }
    fun updateList(s:String, SendOrReciveType: Type)
}