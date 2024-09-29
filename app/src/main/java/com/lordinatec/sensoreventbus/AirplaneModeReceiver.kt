package com.lordinatec.sensoreventbus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class AirplaneModeReceiver(
    private val eventBus: SensorEventBus,
    private val scope: CoroutineScope,
) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            val isAirplaneModeOn = Settings.Global.getInt(
                context?.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON, 0
            ) != 0
            scope.launch {
                if (isAirplaneModeOn) {
                    eventBus.publish(SensorEvent.AirplaneModeOnEvent)
                } else {
                    eventBus.publish(SensorEvent.AirplaneModeOffEvent)
                }
            }
        }
    }
}