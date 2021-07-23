package RabbitMqConnect
import companion.ExchangeName
import com.rabbitmq.client.ConnectionFactory
import companion.message
import java.nio.charset.StandardCharsets

class RabbitMq {
    var fc = factoryCreate()
    init {
        Thread{

            var connection = fc.newConnection()
            var channel = connection.createChannel()

            var Exchange:String = ExchangeName.name
            var QueueName:String = channel.queueDeclare().queue


            channel.exchangeDeclare(Exchange, "topic")
            channel.queueBind(QueueName,Exchange,"")

            while (true){
                if(message.mes != ""){
                    channel.basicPublish(Exchange, "", null, message.mes.toByteArray(StandardCharsets.UTF_8))
                   message.mes = ""
                }
            }
        }.start()
    }


    private fun factoryCreate():ConnectionFactory{
        var factory = ConnectionFactory()
        factory.host ="192.168.0.106"
        factory.username="admin"
        factory.password ="admin"
        return factory
    }

}