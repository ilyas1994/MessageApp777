package Engine.RabbitMq

import android.app.Service
import android.content.Intent
import android.os.IBinder
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
        fun CreateConnection(host:String, username:String, pass:String){
            GlobalScope.launch {
                var  factory =  ConnectionFactory()
                factory.host = host
                factory.username =username
                factory.password = pass
                var connection= factory.newConnection()
                rabbitmq.createChannel(connection)
            }
        }
    override fun onCreate() {
       CreateConnection("192.168.0.108","admin","admin")
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}