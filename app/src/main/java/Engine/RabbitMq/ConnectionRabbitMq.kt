package Engine.RabbitMq

import com.rabbitmq.client.ConnectionFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ConnectionRabbitMq: Service() {


   private  var rabbitmq: RabbitMq = RabbitMq()

    var  sendMes = ""
        companion object{
             private var instance:ConnectionRabbitMq? = null
                fun GetInstance() = synchronized(this) {
                    if(instance == null)
                        instance = ConnectionRabbitMq()
                    instance
                }
        }



        fun SetRecyclerViewAdapter(adapter:IRecyclerViewDispatchUpdatesTo){
            rabbitmq.SetRecyclerViewAdapter(adapter)
        }

    override fun onCreate() {
       CreateConnection("192.168.0.108","admin","admin")
    }
}