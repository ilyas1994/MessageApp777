package Engine.RabbitMq

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowForNetwork {

    var flow = flow<String> {
        for (i in 1..10){
            emit("Hellow")
            delay(1000L)
        }
    }

     fun  a(){
         GlobalScope.launch {
            flow.collect{
                println(it)
            }


         }
     }

}