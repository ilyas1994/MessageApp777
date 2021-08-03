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

class Arr private constructor(){
    companion object {


        private  var recycle: RecyclerView? = null
        private  var mes:String? = null


         fun OK(){

            recycle?.adapter = ChatMain(RabbitMq.dataArr)
        }


        fun setRecycle(s:RecyclerView){
            recycle = s
        }


    }
}

class RabbitMq {

        companion object {
            lateinit var EXCHANGE_NAME:String;
            lateinit var connection:Connection
            lateinit var Channel: Channel

             var dataArr = mutableListOf<String>()
            var sendMes = ""

           lateinit var FR:FragmentChatRV
           var han = Handler()
            var queueName:String = ""
             lateinit  var flow:Flow<String>
        }
        private lateinit var factory:ConnectionFactory
        lateinit var adapter:ChatRecyclerView
        var mHandler = Handler()
        init {
            factory = ConnectionFactory()
            factory.host = "192.168.0.108"
            factory.username ="admin"
            factory.password = "admin"
            EXCHANGE_NAME = "ex"



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
                queueName = Channel.queueDeclare().queue
                Channel.exchangeDeclare(EXCHANGE_NAME, "direct");

                Channel.queueBind(queueName, EXCHANGE_NAME, "X1");
                Listner()

            }catch (e:Exception){
                //                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }

       private fun  Listner(){
            try {


                    val deliverCallback = DeliverCallback { ConsumerTag: String?, delivery: Delivery ->
                            var message = String(delivery.body, StandardCharsets.UTF_8)
                            var s = delivery.envelope.routingKey

                        mHandler.post(Runnable {

                                println( adapter.runCatching {
                                    println(message)
                                    updateList(message)
                                }.isSuccess)

                            // your code to update the UI.
                        })

                            Channel.basicAck(delivery.envelope.deliveryTag, false)

                        }


                    val cancelCallback = CancelCallback { consumerTag: String? ->
                        println("[$consumerTag] was canceled")
                    }

                    Channel.basicConsume(queueName, false, "X1", deliverCallback, cancelCallback)

                } catch (e:Exception){


                }

        }








}