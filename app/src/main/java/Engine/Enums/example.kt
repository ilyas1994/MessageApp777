package Engine.Enums

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class example :Service(){
    override fun onBind(p0: Intent?): IBinder? {
       return null
    }

    override fun onStart(intent: Intent?, startid: Int) {
        Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show()

    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//GlobalScope.launch {
    while (true){
        Toast.makeText(this, "Mokd", Toast.LENGTH_LONG).show()
        Thread.sleep(3000)
    }
//}

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
    }
}