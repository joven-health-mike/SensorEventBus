package com.lordinatec.sensoreventbus.sensor

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.lordinatec.sensoreventbus.android.MyApplication
import com.lordinatec.sensoreventbus.sensor.broadcast.TrafficStatsBroadcast
import com.lordinatec.sensoreventbus.sensor.event.SensorEventBus
import com.lordinatec.sensoreventbus.sensor.event.SensorEventFactory
import kotlinx.coroutines.launch

class TrafficStatsReceiver(
    private val bus: SensorEventBus,
    private val factory: SensorEventFactory
) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val receivedBytes = intent?.getLongExtra(TrafficStatsBroadcast.EXTRA_RX_BYTES, 0)
        val sentBytes = intent?.getLongExtra(TrafficStatsBroadcast.EXTRA_TX_BYTES, 0)
        val scope = (context?.applicationContext as MyApplication).applicationScope
        scope.launch {
            bus.publishEvent(factory.createTrafficStatsEvent(receivedBytes!!, sentBytes!!))
        }
    }
}