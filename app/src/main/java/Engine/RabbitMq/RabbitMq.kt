package Engine.RabbitMq
import View.ViewChat.ViewChat.ChatRecyclerView
import android.content.Context
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.rabbitmq.client.*
import java.nio.charset.StandardCharsets
import kotlin.concurrent.thread


class RabbitMq(exchange_name:String, context:Context) {
        private lateinit var context:Context
        companion object {
             lateinit var EXCHANGE_NAME:String;
            lateinit var connection:Connection
            lateinit var channel: Channel
             var dataArr = mutableListOf<String>()
            var sendMes = ""
            lateinit var adapter: ChatRecyclerView

        }
        private lateinit var factory:ConnectionFactory

        init {
            factory = ConnectionFactory()
            factory.host = "192.168.0.108"
            factory.username ="admin"
            factory.password = "admin"
            EXCHANGE_NAME = exchange_name
            this.context = context
        }

        fun createConnection(){
            Thread{
                try {
                    connection = factory.newConnection()
                    createChanel()
                } catch (e: Exception) {
                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
                }
            }.start()

        }


        private fun createChanel() {
            try {
                if (channel.isOpen) {
                    channel.close()
                }
                channel = connection.createChannel()
                channel.exchangeDeclare(EXCHANGE_NAME, "topic");
                val queueName = channel.queueDeclare().queue
                channel.queueBind(queueName, EXCHANGE_NAME, "");
                Listner()
            }catch (e:Exception){
                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        private fun Listner(){
            while (true) {
                val deliverCallback = DeliverCallback { consumerTag: String?, delivery: Delivery ->
                    var message = String(delivery.body, StandardCharsets.UTF_8)
                    if (message != "") {
                        adapter.addDataClass(message)
                        message = ""
                    }
                    channel.basicAck(delivery.getEnvelope().deliveryTag, true)
                }
                channel.basicConsume("queueName", true, deliverCallback, { consumerTag -> })

               if(sendMes != ""){
                   SendMessage(sendMes)
                   sendMes = ""
               }
            }
        }


        fun SendMessage(data:String){
            try {
                channel.basicPublish(
                    EXCHANGE_NAME,
                    "",
                    null,
                    data.toByteArray(StandardCharsets.UTF_8)
                )

            }catch (e:Exception){
                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }





}