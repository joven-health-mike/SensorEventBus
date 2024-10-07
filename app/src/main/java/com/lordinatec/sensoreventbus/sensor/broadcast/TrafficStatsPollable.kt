package com.lordinatec.sensoreventbus.sensor.broadcast

import android.content.Context
import android.content.Intent
import android.net.TrafficStats

class TrafficStatsPollable : Pollable {
    override fun poll(context: Context) {
        val receivedBytes = TrafficStats.getTotalRxBytes()
        val sentBytes = TrafficStats.getTotalTxBytes()
        val intent = Intent(ACTION).also { intent ->
            intent.putExtra(EXTRA_RX_BYTES, receivedBytes)
            intent.putExtra(EXTRA_TX_BYTES, sentBytes)
        }
        context.sendBroadcast(intent)
    }

    companion object {
        const val ACTION = "com.lordinatec.sensoreventbus.TrafficStatsBroadcast"
        const val EXTRA_RX_BYTES = "receivedBytes"
        const val EXTRA_TX_BYTES = "sentBytes"
    }
}
