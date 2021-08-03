package Engine.RabbitMq

import com.rabbitmq.client.ConnectionFactory

object ConnectionRabbitMq {
    var factory =  ConnectionFactory()
    var  sendMes = ""
    init {
        factory.host = "192.168.0.108"
        factory.username ="admin"
        factory.password = "admin"
    }
}