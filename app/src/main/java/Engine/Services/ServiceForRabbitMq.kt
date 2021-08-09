package Engine.Services

import android.app.Service
import android.content.Intent
import android.os.IBinder

class ServiceForRabbitMq : Service() {

    override fun onCreate() {
        println("Service Started")
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}