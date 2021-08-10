package Engine.RabbitMq

import Engine.Notyfi.Notify
import Engine.Notyfi.notifySingle
import View.ViewChat.ViewChat.FragmentChatRV
import android.app.Service
import android.content.Intent
import android.os.*
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.rabbitmq.client.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import java.nio.charset.StandardCharsets

class ConnectionRabbitMq: Service() {




   private  var EXCHANGE_NAME:String = "ex"

//    private var mHandler = Handler(Looper.myLooper()!!)

        companion object{
             private lateinit  var Channel: Channel
             private lateinit   var connection : Connection
             private lateinit var adapter: IRecyclerViewDispatchUpdatesTo
             private lateinit var notify:Notify
             private var notifyMes:String = ""

             private var instance:ConnectionRabbitMq? = null
                fun GetInstance() = synchronized(this) {
                    if(instance == null) {
                        instance = ConnectionRabbitMq()


                    }
                    instance
                }
        }



        fun SetRecyclerViewAdapter(adapter_:IRecyclerViewDispatchUpdatesTo){
            adapter = adapter_
            println(adapter.toString());
        }




        private fun CreateConnection(host:String, username:String, pass:String){
            GlobalScope.launch {
                var  factory =  ConnectionFactory()
                factory.host = host
                factory.username =username
                factory.password = pass
                 connection = factory.newConnection()

                createChannel(connection)
            }
        }

    fun onCreates() {
//        Toast.makeText(this, "OnCreate", Toast.LENGTH_LONG).show()
        CreateConnection("192.168.0.108","admin","admin")
    }


    override fun onBind(p0: Intent?): IBinder? {

        TODO("Not yet implemented")
    }

    fun StopRabbitMq(){
        connection.close()
    }

  private fun createChannel(connection:Connection){
      Channel = connection.createChannel()
      Channel.exchangeDeclare(EXCHANGE_NAME, "direct");
//      var queueName = Channel.queueDeclare("Xiaomi",false,false,false,null).queue
      var queueName = Channel.queueDeclare("Pixel",false,false,false,null).queue

      Channel.queueBind(queueName, EXCHANGE_NAME, "X2");
//      Channel.queueBind(queueName, EXCHANGE_NAME, "X1");
      Listner(queueName)
  }

    fun SendMessage(data:String){
        try {

            println(data)
           Channel.basicPublish(
                EXCHANGE_NAME,
                "X1",
//                "X2",
                null,
                data.toByteArray(StandardCharsets.UTF_8)
            )

        }catch (e:Exception){
            println("FUCK: "+e.toString())
        }
    }


    private fun  Listner(queueName:String){

        try {
            val deliverCallback =
                DeliverCallback { ConsumerTag: String?, delivery: Delivery ->
                    var message = String(delivery.body, StandardCharsets.UTF_8)
                    notifyMes = message
                    var s = delivery.envelope.routingKey

//
//                    notifySingle.GetNotify().setFragment(FragmentChatRV())
//                    notifySingle.GetNotify().createNotificationChannel(notifyMes)
//                          notifySingle.GetNotify().createNotify()

                    Handler(Looper.getMainLooper()).post(Runnable {
                        adapter.runCatching {
                         updateList(message, IRecyclerViewDispatchUpdatesTo.Type.recive)




                        }
//
                    })
                    Channel.basicAck(delivery.envelope.deliveryTag, false)
                }


            val cancelCallback = CancelCallback { consumerTag: String? ->
                println("[$consumerTag] was canceled")
            }

         Channel.basicConsume(queueName, false, deliverCallback, cancelCallback)

        } catch (e: Exception) {


        }
    }


}