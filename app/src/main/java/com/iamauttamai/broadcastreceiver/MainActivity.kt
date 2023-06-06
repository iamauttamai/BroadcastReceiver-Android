package com.iamauttamai.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var mReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            //do whatever you want
            // if this code is being executed - it's a sign that the user clicked on the notification...
            val notificationDesc = intent?.extras?.getString("toast")
            notificationDesc?.let {
                Toast.makeText(context, "Custom broadcast received", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val receiver = MyBroadcastReceiver()
//        val intentFilter = IntentFilter()
//        intentFilter.addAction("my.custom.broadcast.toast") // Add your custom action
//        registerReceiver(receiver, intentFilter)

        registerReceiver(mReceiver , IntentFilter("my.custom.broadcast.toast"))

        val intent = Intent("my.custom.broadcast.toast") // Use the same custom action
        intent.putExtra("toast", "Y")
        sendBroadcast(intent)

    }
}