package com.lordinatec.sensoreventbus

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.TrafficStats
import android.os.Handler
import android.os.Looper

object EventManager {
    private var airplaneModeReceiver: AirplaneModeReceiver? = null
    private var isPollingTrafficStats = false
    private val trafficStatsHandler = Handler(Looper.getMainLooper())
    private val trafficStatsRunnable = object : Runnable {
        override fun run() {
            pollTrafficStats()
            // Schedule the next poll
            trafficStatsHandler.postDelayed(this, POLLING_INTERVAL)
        }
    }

    fun enableAirplaneModeTracking(context: Context) {
        if (airplaneModeReceiver == null) {
            airplaneModeReceiver = AirplaneModeReceiver()
            val filter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            context.registerReceiver(airplaneModeReceiver, filter)
        }
    }

    fun disableAirplaneModeTracking(context: Context) {
        airplaneModeReceiver?.let {
            context.unregisterReceiver(it)
            airplaneModeReceiver = null
        }
    }

    fun enableTrafficStatsPolling() {
        if (!isPollingTrafficStats) {
            isPollingTrafficStats = true
            trafficStatsHandler.post(trafficStatsRunnable)
        }
    }

    fun disableTrafficStatsPolling() {
        if (isPollingTrafficStats) {
            isPollingTrafficStats = false
            trafficStatsHandler.removeCallbacks(trafficStatsRunnable)
        }
    }

    private fun pollTrafficStats() {
        val receivedBytes = TrafficStats.getTotalRxBytes()
        val sentBytes = TrafficStats.getTotalTxBytes()
        // Create and send analytics event
        AnalyticsManager.onTrafficStatsUpdated(receivedBytes, sentBytes)
    }

    private const val POLLING_INTERVAL = 10_000L  // 10 seconds
}