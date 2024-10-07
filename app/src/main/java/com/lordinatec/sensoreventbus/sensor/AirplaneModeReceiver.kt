package com.lordinatec.sensoreventbus.sensor

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.lordinatec.sensoreventbus.android.MyApplication
import com.lordinatec.sensoreventbus.sensor.event.SensorEventBus
import com.lordinatec.sensoreventbus.sensor.event.SensorEventFactory
import kotlinx.coroutines.launch

class AirplaneModeReceiver(
    private val bus: SensorEventBus,
    private val factory: SensorEventFactory
) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeOn = intent?.getBooleanExtra("state", false) ?: return
        val scope = (context?.applicationContext as MyApplication).applicationScope
        scope.launch {
            bus.publishEvent(factory.createAirplaneModeEvent(isAirplaneModeOn))
        }
    }
}
