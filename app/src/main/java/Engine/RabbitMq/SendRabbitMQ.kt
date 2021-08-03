package Engine.RabbitMq

import View.ViewChat.ViewChat.ChatRecyclerView
import com.rabbitmq.client.Channel
import com.rabbitmq.client.Connection
import com.rabbitmq.client.ConnectionFactory
import com.rabbitmq.client.Delivery
import java.nio.charset.StandardCharsets

class SendRabbitMQ {
    companion object {

        lateinit var EXCHANGE_NAME:String;
        lateinit var connection: Connection
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

            Channel.queueBind(queueName, EXCHANGE_NAME, "X1");

            Listner()
        }catch (e:Exception){
            //                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun Listner(){
            while (true) {
               if(sendMes != ""){
                   SendMessage(sendMes)
                   sendMes = ""
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

}