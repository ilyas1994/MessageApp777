package Engine.RabbitMq

import View.ViewChat.ViewChat.ChatMain
import View.ViewChat.ViewChat.ChatRecyclerView
import View.ViewChat.ViewChat.FragmentChatRV
import android.os.Handler
import androidx.recyclerview.widget.RecyclerView
import com.rabbitmq.client.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.nio.charset.StandardCharsets



class RabbitMq(RecyclerViewAdapter:ChatRecyclerView) {

        private lateinit var queueName:String
        private  var EXCHANGE_NAME:String = "ex"
        private  var EXCHANGE_NAME_RECIVE:String = "ex"
        private lateinit var connection:Connection
        private lateinit var Channel: Channel
        private var factory:ConnectionFactory
        private var adapter:ChatRecyclerView
        private var mHandler = Handler()

        init {
            adapter = RecyclerViewAdapter
            factory = ConnectionRabbitMq.factory
            GlobalScope.launch {
                createConnection()
            }
        }

        fun createConnection() {
            try {
                  connection = factory.newConnection()
                  createChannel()
                } catch (e: Exception) {
    //                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
                }
        }







        private fun createChannel() {
            try {

                Channel = connection.createChannel()
//                queueName = "Pixel2"

//                queueName = Channel.queueDeclare("Xiaomi",false,false,false,null).queue
                queueName = Channel.queueDeclare("Pixel",false,false,false,null).queue
                Channel.exchangeDeclare(EXCHANGE_NAME, "direct");

                Channel.queueBind(queueName, EXCHANGE_NAME, "X2");
                Listner()
                Sending()

            }catch (e:Exception){
                //                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    private fun Sending(){
        while (true) {
            if(ConnectionRabbitMq.sendMes != ""){
                SendMessage(ConnectionRabbitMq.sendMes)
                ConnectionRabbitMq.sendMes = ""
            }
        }
    }

    fun SendMessage(data:String){
        try {
            Channel.basicPublish(
                EXCHANGE_NAME,
                "X1",
                null,
                data.toByteArray(StandardCharsets.UTF_8)
            )

        }catch (e:Exception){
        }
    }

       private fun  Listner(){

//           while (true) {
               try {
//                   Sending()

                   val deliverCallback =
                       DeliverCallback { ConsumerTag: String?, delivery: Delivery ->
                           var message = String(delivery.body, StandardCharsets.UTF_8)
                           var s = delivery.envelope.routingKey

                           mHandler.post(Runnable {

                              adapter.runCatching {
//                                   println(message)
                                   flag = false
                                   updateList(message)
                               }

                               // your code to update the UI.
                           })
                           Channel.basicAck(delivery.envelope.deliveryTag, false)

                       }


                   val cancelCallback = CancelCallback { consumerTag: String? ->
                       println("[$consumerTag] was canceled")
                   }

                   Channel.basicConsume(queueName, false, deliverCallback, cancelCallback)

               } catch (e: Exception) {


               }
//           }

        }








}