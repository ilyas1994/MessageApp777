package Engine.RabbitMq

import com.example.messageapp.MainActivity
import com.rabbitmq.client.ConnectionFactory

object ConnectionRabbitMq{
    var factory =  ConnectionFactory()
    lateinit var mainAct:MainActivity
    var  sendMes = ""
    init {
        factory.host = "192.168.0.108"
        factory.username ="admin"
        factory.password = "admin"
    }
}