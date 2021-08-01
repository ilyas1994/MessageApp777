package Engine.RabbitMq
import View.ViewChat.ViewChat.ChatRecyclerView
import android.content.Context
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.rabbitmq.client.*
import java.nio.charset.StandardCharsets
import kotlin.concurrent.thread


class RabbitMq {

        companion object {
            lateinit var EXCHANGE_NAME:String;
            lateinit var connection:Connection
            lateinit var Channel: Channel
             var dataArr = mutableListOf<String>()
            var sendMes = ""
            lateinit var adapter: ChatRecyclerView

            var queueName:String = ""

        }
        private lateinit var factory:ConnectionFactory

        init {
            factory = ConnectionFactory()
            factory.host = "192.168.0.108"
            factory.username ="admin"
            factory.password = "admin"
            EXCHANGE_NAME = "ex"
            createConnection()
        }

        fun createConnection(){
            Thread{
                try {
                    connection = factory.newConnection()
                    createChannel()

                } catch (e: Exception) {
//                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
                }
            }.start()

        }





        private fun createChannel() {
            try {

                Channel = connection.createChannel()
                queueName = Channel.queueDeclare().queue
                Channel.exchangeDeclare(EXCHANGE_NAME, "direct");

                Channel.queueBind(queueName, EXCHANGE_NAME, "X2");
                Listner()
            }catch (e:Exception){
                //                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        private fun Listner(){

                val deliverCallback = DeliverCallback { ConsumerTag: String?, delivery: Delivery ->
                    var message = String(delivery.body, StandardCharsets.UTF_8)
                    var s = delivery.getEnvelope().routingKey

                    if (message != "") {

                        adapter.addDataClass(message+": ${s}")
                        message = ""
                    }

                    Channel.basicAck(delivery.getEnvelope().deliveryTag, true)
                }

                Channel.basicConsume(queueName, false, deliverCallback, { consumerTag -> })


        }








}