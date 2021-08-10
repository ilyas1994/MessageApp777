package Engine.Notyfi

import View.ViewChat.ViewChat.FragmentChatRV
import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.messageapp.MainActivity
import com.example.messageapp.R


class Notify(context: Context, main: MainActivity) {

    private var context:Context;
    lateinit var notificationChannel: NotificationChannel
    lateinit var service: NotificationManager
   private lateinit var pendingIntent:PendingIntent
    private lateinit var FRmanager:FragmentTransaction
    private var main:MainActivity
    private lateinit var intent:Intent

    private  val description = "qwe"

    companion object {
        lateinit var builder: Notification
        const val NOTIFICATION_ID_INT = 101
        const val CHANNEL_ID_STRING = "Channel 1"
    }

    init {
        this.main = main
        this.context = context
        setFragment(FragmentChatRV())

    }

    fun setFragment(fragment:Fragment){
//        FRmanager = main.supportFragmentManager.beginTransaction().apply {
//            replace(R.id.emptyFragment, fragment)
//            commit()
//        }

        intent = Intent(context, MainActivity::class.java)

    }


    fun SendMessageForIntent(message:String){
        intent.putExtra("InputExtra", message)
    }


    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.O)

     fun startForeground():Notification {
        pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        val channelId =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel("my_service", "My Background Service")
            } else {
                // If earlier version channel ID is not used
                // https://developer.android.com/reference/android/support/v4/app/NotificationCompat.Builder.html#NotificationCompat.Builder(android.content.Context)
                ""
            }

        val notificationBuilder = NotificationCompat.Builder(context, channelId )

        val notification = notificationBuilder.setOngoing(true)
            .setSmallIcon(R.mipmap.ic_launcher)
//            .setPriority(PRIORITY_MIN)
            .setSmallIcon(R.drawable.viewcustomerdesign)
               .setColor(R.color.colorGreen)

               .setShowWhen(true)
            .setCategory(Notification.CATEGORY_SERVICE)
            .setContentIntent(pendingIntent)
            .setContentText(intent.getStringExtra("InputExtra"))
            .setVisibility(Notification.VISIBILITY_PUBLIC)
            .setCategory(Notification.CATEGORY_MESSAGE)
            .build()
        return  notification
//        startForeground(1, notification)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(channelId: String, channelName: String): String{
        val chan = NotificationChannel(
            channelId,
            channelName,
            NotificationManager.IMPORTANCE_LOW
        )
        chan.description = "This is channel 1"

//        val chan = NotificationChannel(channelId,
//            channelName, NotificationManager.IMPORTANCE_NONE)
        chan.lightColor = Color.BLUE
        chan.enableLights(true)

                chan.enableVibration(true)
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        service = context.getSystemService(NotificationManager::class.java)
        service.createNotificationChannel(chan)
        return channelId
    }
//    fun createNotificationChannel() {
//       try {
//
//
//            val intent = intent.apply {
//                flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            }
//
//           val channelId =
//               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                   notificationChannel =  createNotificationChannel()
//               } else {
//                   // If earlier version channel ID is not used
//                   // https://developer.android.com/reference/android/support/v4/app/NotificationCompat.Builder.html#NotificationCompat.Builder(android.content.Context)
//                   ""
//               }
//
////            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                notificationChannel = NotificationChannel(
//                    Notify.CHANNEL_ID_STRING,
//                    description,
//                    NotificationManager.IMPORTANCE_HIGH
//                )
//
//                notificationChannel.enableLights(true)
//                notificationChannel.lightColor = Color.GREEN
//                notificationChannel.enableVibration(false)
//
//                notificationManager = context.getSystemService(NotificationManager::class.java)
//
//                notificationManager.createNotificationChannel(notificationChannel)
//
//
////           pendingIntent =
////               PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
////
////           builder = NotificationCompat.Builder(context, Notify.CHANNEL_ID_STRING)
////               .setSmallIcon(R.drawable.viewcustomerdesign)
////               .setColor(R.color.colorGreen)
////
////               .setShowWhen(true)
////               .setContentTitle("Новое сообщение")
////               .setContentText(intent.getStringExtra("InputExtra").toString())
////               .setContentIntent(pendingIntent)
////               .setVisibility(Notification.VISIBILITY_PUBLIC)
////               .setCategory(Notification.CATEGORY_MESSAGE)
////               .build()
////            } else {
////                builder = Notification.Builder(context, Notify.CHANNEL_ID_STRING)
////                    .setSmallIcon(R.drawable.ic_baseline_arrow_back_24)
////                    .setContentTitle("TITLE2")
////                    .setContentText("TEXT2")
////                    .setContentIntent(pendingIntent)
////                    .build()
////            }
//
//
//        }catch (e:Exception){
//            println("------------------------------------"+e.toString())
//           Toast.makeText(context, "Возможно не вызвали SetFragment перед createNotificationChannel \n"+e.toString(), Toast.LENGTH_LONG).show()
//        }
//    }

//  fun createBuilder(){
////      if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//          pendingIntent =
//              PendingIntent.getActivity(context, 0, intent, 0)
//
//          builder = NotificationCompat.Builder(context, Notify.CHANNEL_ID_STRING)
//              .setSmallIcon(R.drawable.viewcustomerdesign)
//              .setColor(R.color.colorGreen)
//
//              .setShowWhen(true)
//              .setContentTitle("Новое сообщение")
//              .setContentText(intent.getStringExtra("InputExtra").toString())
////          .setContentText(message)
//              .setContentIntent(pendingIntent)
//              .setVisibility(Notification.VISIBILITY_PUBLIC)
//              .setCategory(Notification.CATEGORY_MESSAGE)
//              .build()
////      }
//  }

    fun createNotify(){
        try {
            service.notify(Notify.NOTIFICATION_ID_INT, builder)
        }catch (e:Exception) {
            Toast.makeText(
                context,
                "Возможно не вызвали SetFragment или createNotificationChannel перед CreateNotify \n" + e.toString(),
                Toast.LENGTH_LONG
            ).show()
        }

    }
}