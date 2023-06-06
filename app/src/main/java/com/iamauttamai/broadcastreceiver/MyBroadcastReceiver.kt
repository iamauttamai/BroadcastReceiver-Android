package com.iamauttamai.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Created by AuttaphonL. on 06,June,2023
 */

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action

        action?.let {
            when (it) {
                Intent.ACTION_POWER_CONNECTED -> {
                    // Handle power connected event
                    Toast.makeText(context, "Power connected", Toast.LENGTH_SHORT).show()
                }
                Intent.ACTION_POWER_DISCONNECTED -> {
                    // Handle power disconnected event
                    Toast.makeText(context, "Power disconnected", Toast.LENGTH_SHORT).show()
                }
            }
        }

        if (action != null && action == "my.custom.broadcast.toast") {
            // Handle custom broadcast
            Toast.makeText(context, "Custom broadcast received", Toast.LENGTH_SHORT).show()
        }
    }
}