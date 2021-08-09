package Engine.RabbitMq

import android.os.Handler
import com.rabbitmq.client.*
import java.nio.charset.StandardCharsets



final class RabbitMq  {

        private lateinit var queueName:String
        private  var EXCHANGE_NAME:String = "ex"

        private lateinit var Channel: Channel

        private lateinit var adapter: IRecyclerViewDispatchUpdatesTo
        private var mHandler = Handler()



       fun SetRecyclerViewAdapter(adapter:IRecyclerViewDispatchUpdatesTo){
           this.adapter = adapter
           //jhkhj
       }


        suspend fun createChannel(Connetion:Connection) {
            try {


                Channel = Connetion.createChannel()
                queueName = Channel.queueDeclare("Pixel",false,false,false,null).queue
                Channel.exchangeDeclare(EXCHANGE_NAME, "direct");

                Channel.queueBind(queueName, EXCHANGE_NAME, "X2");
                Listner()
                Sending()

            }catch (e:Exception){
                //                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    suspend private fun Sending(){
        while (true) {
            if(ConnectionRabbitMq().sendMes != ""){
                SendMessage(ConnectionRabbitMq().sendMes)
                ConnectionRabbitMq().sendMes = ""
            }
        }
    }

    suspend  fun SendMessage(data:String){
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

    suspend     private fun  Listner(){
               try {
                   val deliverCallback =
                       DeliverCallback { ConsumerTag: String?, delivery: Delivery ->
                           var message = String(delivery.body, StandardCharsets.UTF_8)
                           var s = delivery.envelope.routingKey

                           mHandler.post(Runnable {

                              adapter.runCatching {
                                   updateList(message, IRecyclerViewDispatchUpdatesTo.Type.recive)
                               }
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