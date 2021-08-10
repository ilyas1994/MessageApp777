package Engine.Notyfi

import android.content.Context
import com.example.messageapp.MainActivity
import kotlinx.coroutines.sync.Semaphore
import java.util.concurrent.locks.ReentrantLock

object notifySingle {

    private lateinit var notify_:Notify



    fun  SetMainActivityContext(context: Context, main: MainActivity){
            notify_ = Notify(context, main)
//        return notify_
    }

    fun  GetNotify():Notify{
            return notify_
    }
}